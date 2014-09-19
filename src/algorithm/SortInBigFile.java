package algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

/*
 * 大文件的排序，文件中是整数
 * 基本方法：将文件划分为多个小文件分别排序，然后进行合并操作
 */
public class SortInBigFile {
	
	private File bigFile = new File("E://bigFile.txt");
	private int pieces = 100;
	private List<String> fileList = new ArrayList<String>();
	
	public void generateBigFile() {
		int max = 10000000;
		Random rand = new Random();
		FileWriter writer = null;
		try {
			writer = new FileWriter(bigFile);
			for (int i = 0; i < max; i++) {
				writer.write(rand.nextInt(Integer.MAX_VALUE) + "\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void sortFile() {
		splitFile(bigFile);
		sortPerFile();
	}
	
	/*
	 * 对每一个文件进行排序
	 */
	public void sortPerFile() {
		for(String filename : fileList) {
			File file = new File(filename);
			int size = (int) (file.length()/4);
			int[] buff = new int[size];
			int i = 0;
			try {
				Scanner scanner = new Scanner(file);
				while(scanner.hasNext()) {
					buff[i++] = scanner.nextInt();
				}
				Arrays.sort(buff);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * 分割文件
	 */
	private void splitFile(File file) {
		long len = file.length(),
				sizePerPart = (len/4/pieces)*4;
		FileInputStream inputStream = null;
		int count = 0;
		try {
			inputStream = new FileInputStream(file);
			while(count < pieces) {
				byte[] buff = new byte[(int) sizePerPart];
				inputStream.skip(count * sizePerPart);
				inputStream.read(buff);
				String pathname = "E://bigFile_temp_"+(count+1)+".txt";
				fileList.add(pathname);
				FileOutputStream outputStream = new FileOutputStream(pathname);
				outputStream.write(buff);
				outputStream.close();
				count++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
//	@Test
//	public void testGenerate() {
//		generateBigFile();
//	}
	
	@Test
	public void testSplit() {
		splitFile(bigFile);
	}
}
