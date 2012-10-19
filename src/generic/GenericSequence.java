package generic;

import java.util.*;

public class GenericSequence {

	public static <T> List getList(Map<String, T> map){
		List list=new ArrayList<T>();
		list.addAll(map.values());
		return list;
	}
	
	public static <T> T[] getArray(Map<String, T> map){
		List list=getList(map);
		return (T[]) list.toArray();
	}
}


class A
{
	String aString;
	A(String aString){
		this.aString=aString;
	}
	@Override
	public String toString() {
		return aString;
	}
	
}