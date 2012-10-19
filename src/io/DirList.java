package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {

	public static void main(String[] args) {
		//将当前的目录创建为一个File对象
		File directory=new File(".");
		//目录下的文件列表
		String[] list;
		//是否指定列出的模式
		if(args.length==0){
			list=directory.list();
		}else {
			list=directory.list(new DirFilter(args[0]));
//			或者这样写：
//			list=directory.list(new FilenameFilter() {
				//匿名内部类访问外部类的局部变量必须是final的哦 
//				private Pattern pattern=Pattern.compile(args[0]);
//				public boolean accept(File arg0, String arg1) {
//					return pattern.matcher(arg1).matches();
//				}
//			});
		}
		//排序
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		//打印
		for(String itemString : list)
			System.out.println(itemString);

	}

}

//DirFilter类可以进行根据文件的name来进行过滤
class DirFilter implements FilenameFilter{
	//所有的正则表达式都将会编译成为pattern类
	private Pattern pattern;
	
	public DirFilter(String regex){
		//构造函数将正则表达式编译为Pattern
		pattern=Pattern.compile(regex);
	}
	
	//accept 方法用来判断dir目录下的名字为name的文件符不符合要求
	public boolean accept(File dir, String name) {
		//将name和pattern进行
		return pattern.matcher(name).matches();
	}
}
