package enumerated;

public class OperationTest {

	//��ö������������һ�����󷽷�������ÿ��ö�ٳ�����ʵ����
	enum Operation {
		PLUS("+") { //constant-specific class body
			@Override
			double apply(double x, double y) {
				return x + y;
			}
		},
		MINUS("-") {
			@Override
			double apply(double x, double y) {
				return x - y;
			}
		},
		TIMES("*") {
			@Override
			double apply(double x, double y) {
				return x * y;
			}
		},
		DIVIDE("/") {
			@Override
			double apply(double x, double y) {
				return x / y;
			}
		};
		
		private final String symbol;
		Operation(String symbol) {
			this.symbol = symbol;
		}
		
		@Override
		public String toString() {
			return symbol;
		}
		
		abstract double apply(double x, double y);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		for(Operation op : Operation.values()) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}

}
