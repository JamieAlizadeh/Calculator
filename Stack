public class Stack
{
	private Object [] stack = null;
	private int top = -1;

	public Stack ()
	{
		stack = new Object [200];
		top = -1;
	}

	public String toString ()
	{
		String str = "[";
		return str + "]" ;
	}

	public Object push (Object obj)
	{
		if (top >= stack.length - 1)
			return false;
		top++;
		stack[top] = obj;

		return obj;
	}

	public Object pop ()
	{
		if (empty() == true)
			return (Object)null;
		top--;

		return stack[top + 1];
	}

	public boolean empty ()
	{
		return (top < 0);
	}

	public Object peek()
	{
		if (empty() == true)
		{
			return (Object)null;
		}
		else
		{
			return stack[top];
		}
	}

}
