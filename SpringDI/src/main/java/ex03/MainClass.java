package ex03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
//		DatabaseDev dev = new DatabaseDev();
//		dev.setUrl("localhost8181");
//		dev.setUid("asr6");
//		dev.setUpw("1234");
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("application-context.xml");
		
		DatabaseDev dev = ctx.getBean(DatabaseDev.class);
		System.out.println(dev.getUrl());
		System.out.println(dev.getUid());
		System.out.println(dev.getUpw());
		
		//1. appl-con 에 memberdao 의존관계표현
		//2. main에서는 getbean메서드를 통해서 값을 출력
		
//		MemberDAO dao = new MemberDAO();
//		dao.setDs(dev);
		
		MemberDAO dao = ctx.getBean(MemberDAO.class);
		
		System.out.println( dao.getDs().getUrl() );
		System.out.println( dao.getDs().getUid() );
		System.out.println( dao.getDs().getUpw() );
		
		
		
	}

}
