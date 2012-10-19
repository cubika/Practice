package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exesise01 {

	/**
	 * @param args
	 * args[0]代表文件扩展名，剩下的是需要搜索的单词
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
		//打印
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
		//使用的是HashSet的传入Collection<?>的构造方法
		//TextFile对象继承了ArrayList，他也是一个Collection
		//第一个参数是文件的绝对路径，第二个是分割使用的正则表达式，即以单词进行分割
		Set<String> words=new HashSet<String>(new 
				TextFile(new File("./src/io/",name).getAbsolutePath(),"\\W+"));
		for(int i=1;i<args.length;i++)
			if(!words.contains(args[i]))
				return false;
		
		return true;
	}
	
	
}
