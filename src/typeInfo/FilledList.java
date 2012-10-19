package typeInfo;

import java.util.ArrayList;
import java.util.List;

class CounterInteger{
	private static long count;
	private final long id=count++;
	public String toString(){
		return Long.toString(id);
	}
}
public class FilledList<T> {

	private Class<T> type;
	public FilledList(Class<T> type){
		this.type=type;
	}
	//Ìî³änElement¸ötypeµÄÊµÀý
	public List<T> create(int nElement){
		List<T> list=new ArrayList<T>();
		try {
			for(int i=0;i<nElement;i++){
				list.add(type.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		FilledList<CounterInteger> fList=
				new FilledList<CounterInteger>(CounterInteger.class);
		System.out.println(fList.create(10));

	}

}
