package enumerated;

//ö�ٵĻ����÷�
public class WeightTable {

	enum Planet {
		//ö�ٳ���
		MERCURY(3.302e+23,2.439e6),
		VENUS(4.869e+24,6.052e6),
		EARTH(5.975e+24,6.378e6);
		
		//��ӵ�ö���е���
		private final double mass; //����
		private final double radius; //�뾶
		private final double surfaceGravity; //����
		
		private static final double G = 6.67300E-11;
		
		//������
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
		public double surfaceWeight(double mass) { //����һ�����������
			return mass * surfaceGravity;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double earthWeight = Double.parseDouble(args[0]); //�����ϵ�����
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		for(Planet p : Planet.values()) {
			System.out.printf("Weight on %s is %f%n", p,p.surfaceWeight(mass));
		}

	}

}
