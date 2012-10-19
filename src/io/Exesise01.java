package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exesise01 {

	/**
	 * @param args
	 * args[0]�����ļ���չ����ʣ�µ�����Ҫ�����ĵ���
	 */
	public static void main(final String[] args) {
		File path=new File("./src/io/");
		String[] list;
		if(args.length==0){
			list=path.list();
		}else{
			list=path.list(new WordsFilter(args));
		}
		
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		//��ӡ
		for(String itemString : list)
			System.out.println(itemString);

	}

}

class WordsFilter implements FilenameFilter{
	
	private String[] args;
	public WordsFilter(String[] args){
		this.args=args;
	}

	public boolean accept(File dir, String name) {
		String[] splitArrays=name.split("\\.");
		String extension=splitArrays[splitArrays.length-1];
		if(!extension.equals(args[0]))
			return false;
		
		if(args.length==1)
			return true;
		//ʹ�õ���HashSet�Ĵ���Collection<?>�Ĺ��췽��
		//TextFile����̳���ArrayList����Ҳ��һ��Collection
		//��һ���������ļ��ľ���·�����ڶ����Ƿָ�ʹ�õ�������ʽ�����Ե��ʽ��зָ�
		Set<String> words=new HashSet<String>(new 
				TextFile(new File("./src/io/",name).getAbsolutePath(),"\\W+"));
		for(int i=1;i<args.length;i++)
			if(!words.contains(args[i]))
				return false;
		
		return true;
	}
	
	
}
