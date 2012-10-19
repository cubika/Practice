package typeInfo;

interface HasBatteries{}
interface WaterProof{}
interface Shoots{}

class Toy implements HasBatteries,WaterProof,Shoots{
	 Toy(){}
	 Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries,WaterProof,Shoots {
	FancyToy(){super(1);}
}
public class ToyTest {
	
	static void printInfo(Class<?> c){
		System.out.println("Class Name: "+c.getName()+" Is interface? ["+c.isInterface()+"]");
		System.out.println("Simple Name: "+c.getSimpleName());
		System.out.println("Canonical Name:"+c.getCanonicalName());
	}
	public static void main(String[] args) {
		Class c=null;
		try {
			c=Class.forName("typeInfo.FancyToy");
		} catch (Exception e) {
			System.out.println("Cann't find fancyToy");
		}
		printInfo(c);
		
		for(Class face : c.getInterfaces()){
			printInfo(face);
		}
		
		Class superClass=c.getSuperclass();
		Object superReference=null;
		try {
			superReference=superClass.newInstance();
		} catch (Exception e) {
			System.out.println("cannot instantiate");
		}
		printInfo(superReference.getClass());

	}

}
