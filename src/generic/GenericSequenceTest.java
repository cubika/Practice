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
			System.out.println("java���Դ�������List��");
		} catch (Exception e) {
			e.printStackTrace();
			fail("java �����Դ�������List��");
		}
	}

	@Test
	public void testGetArray() {
		try {
			A[] arrays=(A[])GenericSequence.getArray(testMap);
			for(int i=0;i<arrays.length;i++)
				System.out.println(arrays[i]);
			System.out.println("java���Դ����������飡");
		} catch (Exception e) {
			fail("java�����Դ����������飡");
		}
	}

}
