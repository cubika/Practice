package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {

	public static void main(String[] args) {
		//����ǰ��Ŀ¼����Ϊһ��File����
		File directory=new File(".");
		//Ŀ¼�µ��ļ��б�
		String[] list;
		//�Ƿ�ָ���г���ģʽ
		if(args.length==0){
			list=directory.list();
		}else {
			list=directory.list(new DirFilter(args[0]));
//			��������д��
//			list=directory.list(new FilenameFilter() {
				//�����ڲ�������ⲿ��ľֲ�����������final��Ŷ 
//				private Pattern pattern=Pattern.compile(args[0]);
//				public boolean accept(File arg0, String arg1) {
//					return pattern.matcher(arg1).matches();
//				}
//			});
		}
		//����
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		//��ӡ
		for(String itemString : list)
			System.out.println(itemString);

	}

}

//DirFilter����Խ��и����ļ���name�����й���
class DirFilter implements FilenameFilter{
	//���е�������ʽ����������Ϊpattern��
	private Pattern pattern;
	
	public DirFilter(String regex){
		//���캯����������ʽ����ΪPattern
		pattern=Pattern.compile(regex);
	}
	
	//accept ���������ж�dirĿ¼�µ�����Ϊname���ļ���������Ҫ��
	public boolean accept(File dir, String name) {
		//��name��pattern����
		return pattern.matcher(name).matches();
	}
}
