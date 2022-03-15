package ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Printer {

	/*
	 * @Autowired -> 자동주입 타입 -> 이름
	 * 
	 * @Autowired(required = false)
	 * 스프링이 빈을 주입할때 주입할빈이없으면 에러를 발생시키는데,
	 * 이를무시하고 지나가는 옵션
	 * 
	 * @Qualifier
	 * 컨테이너에 동일한 객체가 여러개있을때 이름으로 강제연결하는 어노테이션
	 * 
	 */
	
	@Autowired(required = false)
	@Qualifier("aaa")
	private Document doc;

	//기본생성자
	public Printer() {
		// TODO Auto-generated constructor stub
	}
	
	//생성자
	
	public Printer(Document doc) {
		super();
		this.doc = doc;
	}

	public Document getDoc() {
		return doc;
	}
	
	
	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
	
	
}
