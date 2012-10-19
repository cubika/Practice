package container;

import java.util.*;

public class PrintContainer {
	
	//���ص�����fill����
	static Collection<String> fill(Collection<String> c){
		c.add("dog");
		c.add("dog");
		c.add("cat");
		return c;
	}
	static Map<String, String> fill(Map<String, String> m){
		m.put("dog", "Puppy");
		m.put("cat", "Tom");
		m.put("dog", "Razer");
		return m;
	}
	public static void main(String[] args) {
		//ArrayList��List��һ�֣�HashSet��Set��һ�֣����Ƕ�����Collection��HashMap����Map
		//��Щ������toString�����Ѿ��ܺ��ˣ�����Ҫ��д��
		System.out.println(fill(new ArrayList<String>()));
		System.out.println(fill(new HashSet<String>()));
		System.out.println(fill(new HashMap<String,String>()));
		
		//ʹ����Collections��fill�������ǳ���׾��ֻ�ܽ����滻
		List<String> list=new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add("");
		}
		Collections.fill(list, "Hello");
		System.out.println(list);
		
	}

}
