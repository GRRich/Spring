package ex07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ex01.SpringTest;
import ex02.Hotel;

public class MainClass {
	
	public static void main(String[] args) {
		
		//자바파일을 설정파일로 쓸때는 제네릭~컨텍스트를 상속받는 아래클래스를 사용
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		SpringTest st = ctx.getBean(SpringTest.class);
		st.test();
		
		Hotel hotel = ctx.getBean(Hotel.class);
		hotel.getChef().cooking();
		
		
		
		
	}

}
