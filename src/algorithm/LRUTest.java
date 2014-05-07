package algorithm;

import java.util.*;
//��չһ��LinkedHashMap����࣬����ʵ��LRU�㷨
class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V>{
	//���建�������
	private int capacity;
	private static final long serialVersionUID = 1L;
	//�������Ĺ�����	
	LRULinkedHashMap(int capacity){
		//����LinkedHashMap�Ĺ��������������²���
		super(16,0.75f,true);
		//����ָ���Ļ����������
		this.capacity=capacity;
	}
	//ʵ��LRU�Ĺؼ����������map�����Ԫ�ظ��������˻��������������ɾ������Ķ���Ԫ��
	@Override
	public boolean removeEldestEntry(Map.Entry<K, V> eldest){ 
//		System.out.println(eldest.getKey() + "=" + eldest.getValue());
		return size() > capacity;
	}  
}
//������
public class LRUTest{
	public static void main(String[] args) throws Exception{

		//ָ�������������Ϊ4
		Map<Integer,Integer> map=new LRULinkedHashMap<>(4);
		map.put(9,3);
		map.put(7,4);
		map.put(5,9);
		map.put(3,4);
		map.put(6,6);
		//�ܹ�put��5��Ԫ�أ�������ָ���Ļ����������
		//�������
		for(Iterator<Map.Entry<Integer,Integer>> it=map.entrySet().iterator();it.hasNext();){
			Map.Entry<Integer, Integer> curEntry = it.next();
			System.out.println(curEntry.getKey() + " = " + curEntry.getValue());
		}
	}
}

