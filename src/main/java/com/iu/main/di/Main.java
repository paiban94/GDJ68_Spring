package com.iu.main.di;

public class Main {

	public static void main(String[] args) {
/*		// TODO Auto-generated method stub
		Robot robot = new Robot(); //로봇 한대 만들라는 뜻은 객체생성
		Arm arm = new Arm();
		robot.setArm(arm); // 로봇에게 팔을끼워넣자 set(주입 -- 생성자도 주입)
		//넣어주는 작업을 한글로는 주입, 영어는 injection
		System.out.println(robot.getArm());  */
		
		//로봇의 팔을 가져오자 , 팔을 가져오고 싶으면 팔 객체 필요
		// 로봇은 팔에 대해서 의존적이다 -- dependency
		// 합치면 DI(Dependency Injection = 의존성 주입) *중요
		// 주입방식은 method 와 생성자 방식이 있다.  
		
		
		Arm arm /*변수 선언*/= new Arm();/*객체 생성*/
		Robot robot = new Robot();
		
		robot.setArm(arm);
	}
	
}
