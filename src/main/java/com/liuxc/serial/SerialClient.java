package com.liuxc.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * http://developer.51cto.com/art/201202/317181.htm
 * 
 * @since:2017年10月26日
 * @author:liuxc
 */
public class SerialClient {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("persons.out");
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

		SerialPerson p = new SerialPerson();
		p.setName("001");
		p.setGender(Gender.male);
		p.setAge(25);
		
		oos.writeObject(p);
		
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		SerialPerson person = (SerialPerson) ois.readObject();
		ois.close();
		System.out.println(person);
	}

}
