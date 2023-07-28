package com.iu.main.file;

import static org.junit.Assert.*;import java.time.Month;
import java.util.Calendar;
import java.util.Random;

import org.junit.Test;

import com.iu.main.Mytest;

public class CalendarTest extends Mytest  {

	public void test2() {
		Calendar ca = Calendar.getInstance();
		Random random = new Random(ca.getTimeInMillis());
		random.nextInt();
		random.nextInt(5);
	}
	//@Test
	public void test() {
		//1. Random
		Calendar ca = Calendar.getInstance();
		System.out.println(ca);
		System.out.println(ca.getTime());
		
		System.out.println(ca.get(Calendar.YEAR));
		System.out.println(ca.get(Calendar.DATE));
		System.out.println(ca.get(Calendar.MONTH));

		ca.set(Calendar.YEAR, 1994);
		
		System.out.println(ca.getTime());
		System.out.println("==================");
		ca = Calendar.getInstance();
		Calendar ca2 = Calendar.getInstance();
		ca2.set(2023, 6, 27, 18, 20);
	
		long l1=ca.getTimeInMillis();
		long l2=ca2.getTimeInMillis();
		long result = l2-l1;
		System.out.println(result/(1000*60));
	}

}
