package Calculator;

public class OperationImpl implements Operation{

	@Override
	public double add(double a, double b) {
		return a+b;
	}

	@Override
	public double subtract(double a, double b) {
		return a-b;
	}

	@Override
	public double multiply(double a, double b) {
		return a*b;
	}

	@Override
	public int divide(int a, int b) {
		return a/b;
	}

}
