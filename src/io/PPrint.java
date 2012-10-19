package io;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/*
 * 打印Collection
 */
public class PPrint {

	//将Collection转化为一个字符串
	public static String pformat(Collection<?> c){
		if(c.isEmpty()) return "[]";
		StringBuilder sb=new StringBuilder("[");
//		Iterator<?> iterator=c.iterator();
//		while(iterator.hasNext()){
//			sb.append("\n");
//			sb.append(iterator.next());
//		}
//		sb.append("\n ]");
		for (Object object : c) {
			if(c.size()!=1)
				sb.append("\n ");
			sb.append(object);
		}
		if(c.size()!=1)
			sb.append("\n ");
		sb.append("]");
		return sb.toString();
	}
	
	//打印Collection
	public static void pprint(Collection<?> c){
		System.out.println(pformat(c));
	}
	
	//将Object数组作为Collection进行打印
	public static void pprint(Object[] obj){
		System.out.println(Arrays.asList(obj));
	}
}
