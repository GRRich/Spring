package ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
//		Chef c = new Chef();
//		
//		Hotel h = new Hotel(c);
//		
//		h.getChef().cooking();
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("application-context.xml");
		
		//1st
//		Hotel h = ctx.getBean(Hotel.class);
//		h.getChef().cooking();
		
		Hotel h = (Hotel)ctx.getBean("h");
		h.getChef().cooking();
		
		
		
	}

}
