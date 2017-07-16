import java.util.*;
public class Calc
{
	public static final int NUMBER = 0;
	public static final int OPERATOR = 1;

	public double exec(String expr)
	{
		System.out.println("Initial Expression: " + expr);

		expr = expr.replaceAll(" ","");
		expr = "("+expr+")";
		expr = expr.replaceAll("\\(\\-","(0-") ;
		expr = expr.replaceAll("\\(\\+","(") ;

		System.out.println("After Preprosessing: " + expr);

		Queue infix   = parse(expr);
			System.out.println("After Parsing: " + infix);

		Queue postfix = compile(infix);
			System.out.println("after Compiling: " + postfix);

		double result = compute(postfix);
			System.out.println("After Computing: " + result);

		return result;
	}


	private Queue parse(String expr)
	{
		Queue queue = new Queue();
		int index = 0;

		while(index < expr.length())
		{
			char ch = expr.charAt(index);

			if(isOperator(ch) == true)
			{
				Token t = new Token(OPERATOR, 0.0,ch);
				queue.insert(t);
				index++;
			}
			else
			{
				String number = "";
				while(isOperator(ch) == false)
				{
					number = number + ch;
					index++;
					ch = expr.charAt(index);
				}
				double d = Double.parseDouble(number);
				Token t = new Token(NUMBER, d, 'X');
				queue.insert(t);
			}
		}
		return queue;
	}


	private Queue compile(Queue infix)
	{
		Stack stack = new Stack();

		Queue postfix = new Queue();

		while (!infix.empty())
		{
			Token t = (Token) infix.remove();

			if (t.type == NUMBER)
			{
				postfix.insert ((Object)t);
			}
			else
			{
				if (t.operator == '(')
				{
					stack.push((Object)t);
				}

				if (t.operator == ')')
				{
					Token tmp = (Token) stack.pop();

					while (tmp.operator != '(')
					{
						postfix.insert ((Object)tmp);

						tmp = (Token) stack.pop();
					}
				}

				if (t.operator == '^')
				{
					stack.push((Object)t);
				}

				if (t.operator == '*')
				{
					Token top = (Token) stack.peek();

					while(top.operator != '(' && top.operator != '+' && top.operator != '-')
					{
							top = (Token) stack.pop();
							postfix.insert((Object)top);
							top = (Token) stack.peek();
					}
					stack.push(t) ;
				}

				if (t.operator == '/')
				{
					Token top = (Token) stack.peek();

					while(top.operator != '(' && top.operator != '+' && top.operator != '-')
					{
							top = (Token) stack.pop();
							postfix.insert((Object)top);
							top = (Token) stack.peek();
					}
					stack.push(t) ;
				}

				if (t.operator == '+')
				{
					Token top = (Token) stack.peek();

					while (top.operator != '(')
					{
						top = (Token) stack.pop();
						postfix.insert((Object)top);
						top = (Token) stack.peek();
					}

					stack.push(t) ;
				}

				if (t.operator == '-')
				{
					Token top = (Token) stack.peek();

					while (top.operator != '(')
					{
						top = (Token) stack.pop();
						postfix.insert((Object)top);
						top = (Token) stack.peek();
					}

					stack.push(t) ;

				}
			}
		}


		return postfix;
	}


	private double compute(Queue postfix)
	{

		Stack stack = new Stack();

		while (postfix.empty() == false)
		{
			Token t = (Token) postfix.remove();
			double n = 0;


			if ( t.type == NUMBER )
			{
				stack.push((Object)t);
			}
			else
			{
				Token right = (Token) stack.pop();
				Token left = (Token) stack.pop();

				if (t.operator == '+')
				{
					n = left.number + right.number;


					Token tkn = new Token( NUMBER, n, 'x');
					stack.push(tkn);
				}

				if (t.operator == '-')
				{
					n = left.number - right.number;


					Token tkn = new Token( NUMBER, n, 'x');
					stack.push(tkn);
				}

				if (t.operator == '*')
				{
					n = left.number * right.number;


					Token tkn = new Token( NUMBER, n, 'x');
					stack.push(tkn);
				}

				if (t.operator == '/')
				{
					n = left.number / right.number;


					Token tkn = new Token( NUMBER, n, 'x');
					stack.push(tkn);
				}

				if (t.operator == '^')
				{
					n = java.lang.Math.pow (left.number,right.number);
																		
					Token tkn = new Token( NUMBER, n, 'x');
					stack.push(tkn);
				}

			}

		}

		Token ans = (Token) stack.pop();

		return ans.number;
	}


	private boolean isOperator(char ch)
	{
		String s = "()+-/^*";
		return (s.indexOf(ch)>=0);
	}
}



class Token
{
	public int type;
	public double number;
	public char operator;

	public Token(int t, double v, char op)
	{
		type 		 = t;
		number		 = v;
		operator	 = op;
	}

	public String toString()
	{
		if (type == Calc.NUMBER)
		{
			return "" + number;
		}

		return "" + operator;
	}
}
