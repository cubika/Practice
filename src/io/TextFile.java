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
	
	//��textд���ļ���
	public static void write(String fileName,String text){
		try{
			PrintWriter pw=new PrintWriter(new File(fileName).getAbsoluteFile());
			//print�������Խ��������͵�����ת�����ַ�������ʽ��������ص�write����ֻ������ַ����ַ����顢�ַ��������ַ���ص����ݡ�
			pw.print(text);
			pw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//ArrayList��һ��String���飬���TextFileҲ��һ��String����
	//���ԣ����캯���������ǽ�������鰴�Լ�������������
	public TextFile(String fileName,String spliter){
		
		//ʹ��read�����������ļ������ݱ�Ϊһ���ַ�����Ȼ��ʹ��spliter���зָ���ϳ�Ϊһ��ArrayList
		super(Arrays.asList(read(fileName).split(spliter)));
		
		//����TextFile�̳���ArrayList�������String get(int index)����
		//��split֮��ArrayListΪ��ʱ����ɾ����ʹ֮���ױ�Ϊ��ֵ
		if(get(0).equals("")) remove(0);
	}
	
	//һ����Ϊһ������Ĺ��캯��
	public TextFile(String fileName){
		this(fileName, "\n");
	}
	
	//��split����ַ���������Ӧ��file
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
		//treeSet���ź���ģ�������Щ����ĸС��a�ļ��ϣ�������ĸ��д�Ĵ�
		System.out.println(treeSet.headSet("a"));
	}

}
