package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;


public class TextFile extends ArrayList<String>{

	//read a file as a single string
	public static String read(String fileName) {
		StringBuilder sb=new StringBuilder();
		try{
			BufferedReader br=new BufferedReader(new FileReader(new 
					File(fileName).getAbsoluteFile()));
			
			String s;
			while((s=br.readLine())!=null)
				sb.append(s);
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}

		return sb.toString();
	}
	
	//将text写入文件里
	public static void write(String fileName,String text){
		try{
			PrintWriter pw=new PrintWriter(new File(fileName).getAbsoluteFile());
			//print方法可以将各种类型的数据转换成字符串的形式输出。重载的write方法只能输出字符、字符数组、字符串等与字符相关的数据。
			pw.print(text);
			pw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//ArrayList有一个String数组，因此TextFile也有一个String数组
	//所以，构造函数的作用是将这个数组按自己的需求进行填充
	public TextFile(String fileName,String spliter){
		
		//使用read方法将整个文件的内容变为一个字符串，然后使用spliter进行分割，最后合成为一个ArrayList
		super(Arrays.asList(read(fileName).split(spliter)));
		
		//由于TextFile继承了ArrayList，因此有String get(int index)方法
		//当split之后ArrayList为空时，就删掉，使之彻底变为空值
		if(get(0).equals("")) remove(0);
	}
	
	//一行作为一个整体的构造函数
	public TextFile(String fileName){
		this(fileName, "\n");
	}
	
	//将split后的字符串填入相应的file
	public void write(String filename){
		try{
			PrintWriter pw=new PrintWriter(new File(filename).getAbsoluteFile());
			for(String item:this)
				pw.println(item);
			pw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		String text=read("./src/io/TextFile.java");
		write("textFile.txt", text);
		TreeSet<String> treeSet=new TreeSet<String>(new TextFile("textFile.txt","\\W+"));
		//treeSet是排好序的，返回那些首字母小于a的集合，即首字母大写的词
		System.out.println(treeSet.headSet("a"));
	}

}
