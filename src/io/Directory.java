package io;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Directory {

	//ӵ��files��dirs�Ķ�ά���ݽṹ
	public static class TreeInfo implements Iterable<File>{
		List<File> files=new ArrayList<File>();
		List<File> dirs=new ArrayList<File>();

		//Ĭ�ϵĵ�������files�ĵ�����
		public Iterator<File> iterator(){
			return files.iterator();
		}
		
		public void addAll(TreeInfo other){
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}
		public String toString(){
			return "Dirs:"+PPrint.pformat(dirs)+
					"\n\nFiles:"+PPrint.pformat(files);
		}
	}
	
	//�ݹ��г��ļ��к��ļ�
	static TreeInfo recurseDirs(File startdir,String regex){
		TreeInfo result=new TreeInfo();
		result.dirs.add(startdir);

		for(File file:startdir.listFiles()){
			if(file.isDirectory()){
				result.dirs.add(file);
				result.addAll(recurseDirs(file, regex));
			}else {
				if(file.getName().matches(regex))
					result.files.add(file);
			}
		}
		return result;
	}
	
	//�ĸ��汾��walk����,��ʵ��recurseDirs�������汾
	public static TreeInfo walk(File start){
		return recurseDirs(start, ".*");
	}
	public static TreeInfo walk(String start){
		return recurseDirs(new File(start), ".*");
	}
	public static TreeInfo walk(File start,String regex){
		return recurseDirs(start, regex);
	}
	public static TreeInfo walk(String start,String regex){
		return recurseDirs(new File(start), regex);
	}
	
		
	public static void main(String[] args) {
		if(args.length==0)
			System.out.println(walk("."));
		else {
			for (String arg : args) {
				System.out.println(walk(arg));
			}
		}
	}
}
