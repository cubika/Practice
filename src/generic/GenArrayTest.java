package generic;

class GenClass<T>{
	T value;
	
	void setValue(T t){
		value=t;
	}
	
	T getValue(){
		return value;
	}
}

public class GenArrayTest {

	public static void main(String[] args){
		//下面这一行是不成立的，但假如成立，就会有下面的这样一种情况
/*		GenClass<String>[] array=new GenClass<String>[2];
		Object[] genObjects=array;
		GenClass<StringBuffer> sbClass = new GenClass<StringBuffer>();
		sbClass.setValue(new StringBuffer("123"));
		genObjects[0]=sbClass;
		System.out.println(array[0].getValue());*/
	}
}
