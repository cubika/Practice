package io;

import io.Person.Gender;
import java.io.*;

public class SimpleSerial {

	public static void main(String[] args) throws Exception{
		File file=new File("E://temporary/personSerial.ser");
		
		Person tom=new Person("Tom",24,Gender.MALE);
		if(!file.exists()){
			file.createNewFile();
		}
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(tom);
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
		Object readPerson=ois.readObject();
		
		oos.close();
		ois.close();
		System.out.println(readPerson);
		
	}
}
