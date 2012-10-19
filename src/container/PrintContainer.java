package container;

import java.util.*;

public class PrintContainer {
	
	//重载的两个fill方法
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
		//ArrayList是List的一种，HashSet是Set的一种，它们都属于Collection，HashMap属于Map
		//这些容器的toString（）已经很好了，不需要重写了
		System.out.println(fill(new ArrayList<String>()));
		System.out.println(fill(new HashSet<String>()));
		System.out.println(fill(new HashMap<String,String>()));
		
		//使用了Collections的fill方法，非常笨拙，只能进行替换
		List<String> list=new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add("");
		}
		Collections.fill(list, "Hello");
		System.out.println(list);
		
	}

}
