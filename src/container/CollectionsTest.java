package container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CollectionsTest {
	private List<String> list = new ArrayList<String>();
	
	@Before
	public void init(){
		list.add("Mike");
		list.add("Sun");
		list.add("Coco");
		list.add("Marion");
		list.add("Paul");
	}
	
	@Test
	public void testUnmodified(){
		System.out.println("list: " + list);
		List<String> unmodifyList = Collections.unmodifiableList(list);
		unmodifyList.add("newTest");
	}

	@Test
	public void testSort() {
		System.out.println("ԭʼ˳��"+list);
		Collections.reverse(list);
		System.out.println("reverse��˳��"+list);
		Collections.shuffle(list);
		System.out.println("shuffle��˳��"+list);
		Collections.swap(list, 0, 3);
		System.out.println("swap��˳��"+list);
		Collections.rotate(list, 1);
		System.out.println("rotate��˳��"+list);
	}
	
	 @Test
	 public void testSearch() {
		 System.out.println("������list��" + list);
		 System.out.println("max��" + Collections.max(list));
		 System.out.println("frenquency��" + Collections.frequency(list,"Mike"));
		 Collections.replaceAll(list, "Mike", "mickle");
		 System.out.println("replaceAll֮��" + list);
	 }

}
