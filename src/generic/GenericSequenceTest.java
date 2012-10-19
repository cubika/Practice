package generic;


import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

import java.util.*;

public class GenericSequenceTest extends TestCase {

	private Map<String, A> testMap=new HashMap<String, A>();
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		testMap.put("bob", new A("hello"));
		
	}

	@Test
	public void testGetList() {
		try {
			List<A> list=GenericSequence.getList(testMap);
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i));
			System.out.println("java可以创建泛型List！");
		} catch (Exception e) {
			e.printStackTrace();
			fail("java 不可以创建泛型List！");
		}
	}

	@Test
	public void testGetArray() {
		try {
			A[] arrays=(A[])GenericSequence.getArray(testMap);
			for(int i=0;i<arrays.length;i++)
				System.out.println(arrays[i]);
			System.out.println("java可以创建泛型数组！");
		} catch (Exception e) {
			fail("java不可以创建泛型数组！");
		}
	}

}
