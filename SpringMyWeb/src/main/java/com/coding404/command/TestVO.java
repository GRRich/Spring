package com.coding404.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //게터세터 자동생성
@AllArgsConstructor //모든멤버변수를 매개변수로 받는 생성자 자동생성
@NoArgsConstructor //기본생성자 자동생성
public class TestVO {
	
	private String name;
	private int age;
	private String addr;

}
