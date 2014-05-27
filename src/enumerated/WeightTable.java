package enumerated;

//枚举的基本用法
public class WeightTable {

	enum Planet {
		//枚举常量
		MERCURY(3.302e+23,2.439e6),
		VENUS(4.869e+24,6.052e6),
		EARTH(5.975e+24,6.378e6);
		
		//添加到枚举中的域
		private final double mass; //质量
		private final double radius; //半径
		private final double surfaceGravity; //重力
		
		private static final double G = 6.67300E-11;
		
		//构造器
		Planet(double mass, double radius) {
			this.mass = mass;
			this.radius = radius;
			surfaceGravity = G * mass / (radius * radius);
		}
		
		public double mass() {
			return mass;
		}
		public double radius() {
			return radius;
		}
		public double surfaceGravity() {
			return surfaceGravity;
		}
		public double surfaceWeight(double mass) { //计算一个物体的重量
			return mass * surfaceGravity;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double earthWeight = Double.parseDouble(args[0]); //地球上的重量
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		for(Planet p : Planet.values()) {
			System.out.printf("Weight on %s is %f%n", p,p.surfaceWeight(mass));
		}

	}

}
