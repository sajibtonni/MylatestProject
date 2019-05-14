package practice;

import org.openqa.selenium.WebElement;

public class Practice extends A{
	
	public static void main(String[] args) {
		
		
		
		
	}

}

class A  {
	
	private final int day1 = 1;
	private final int day2 = 2;
	private final int day3 = 3;
	private final int day4 = 4;
	private final int day5 = 5;
	private final int day6 = 6;
	private final int day7 = 7;
	private final int day8 = 8;
	
	public WebElement myFristName(int locator, String value) {
		
		WebElement e = null;
		switch (locator) {
		  case day1:
		    System.out.println(value);
		    break;
		  case day2:
		    System.out.println(value);
		    break;
		  case day4:
		    System.out.println(value);
		    break;
		  case day5:
		    System.out.println(value);
		    break;
		  case day6:
		    System.out.println(value);
		    break;
		  case day7:
		    System.out.println(value);
		    break;
		  case day8:
		    System.out.println(value);
		    break;
		}
		return e;
	}

}

class B extends A {
	public void myLastName() {
		String name = "BBBB";
		System.out.println(name);
	}

	class C extends A {
		public void myNickName() {
			String name = "CCCC";
			System.out.println(name);
		}

	}
}
