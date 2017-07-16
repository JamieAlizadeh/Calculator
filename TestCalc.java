import java.util.*;
public class TestCalc
{
	public static void main(String[] args)
	{
		String expr = "7*(3-1)^2+8/4;
		Calc calc = new Calc();

		double res = calc.exec(expr);

		System.out.println(res);
	}
}
