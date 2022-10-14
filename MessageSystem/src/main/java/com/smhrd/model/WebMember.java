package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//골뱅이Data: 기본생성자,getter,setter만들어줌
//골뱅이AllArgsConstructor: 매개변수 4개 다 있는 생성자 만들어 줌(필드에 있는 변수를 다 포함한 생성자)
@AllArgsConstructor
@Data
public class WebMember {
	private String email;
	private String pw;
	private String tel;
	private String address;
	
}
