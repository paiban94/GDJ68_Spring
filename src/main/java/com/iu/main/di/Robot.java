package com.iu.main.di;

public class Robot {

		private String name;

		private static Robot robot;
		
		private Arm arm; // 로봇이 팔을 가지고 있다 라는 뜻
		//SingleTone 객체 하나 만들떄 사용
		public Robot() {
			//this.arm = new Arm(); // 생성자 방식
			// 결합도가 높다(강하다)
			//한 객체가 소멸되면 arm도 같이 소멸
		}
		
		public Robot(Arm arm) { // 생성자 방식
			this.arm = arm;
			//결합도가 낮다(약하다)
		}
		
		public static Robot getInstance() {
			if(robot==null) 
			{
				Robot.robot=new Robot();			}
			
			return Robot.robot;
		}
		
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Arm getArm() {
			return arm;
		}

		public void setArm(Arm arm) {
			this.arm = arm;
		}
}
