package ex06;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("autowired-context.xml");
		
		Airplane air = ctx.getBean(Airplane.class);
		
		air.getBattery().energy();
		
		
	}

}
