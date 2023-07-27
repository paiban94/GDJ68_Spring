package com.iu.main.file;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.iu.main.Mytest;

public class FileTest extends Mytest {

	@Test
	public void test() {
		//File 클래스
		File file = new File("C:\\Study\\study.txt");
		
		System.out.println(file.exists());
		System.out.println(file.isFile());
		file = new File("C:\\Study","study.txt");
		System.out.println("===============");
		file = new File("C:\\study");
		System.out.println(file.exists());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println("===============");
		file = new File(file,"ex");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		file.delete();
		file = new File("C:\\study\\study.txt");
		file.delete();
		
		file = new File("C:\\Study");
		//file.delete();
		String [] list=file.list();
		//향상된 for 문
		//for(Collection에서 모은타입 변수명:Collection변수명)
		for(String str:list) {
			System.out.println(str);
			}		
	
		file = new File(file, "t1");
		file.mkdir();
		
		file = new File(file, "sub1\\sub2");
		file.mkdirs();
	}	

}
