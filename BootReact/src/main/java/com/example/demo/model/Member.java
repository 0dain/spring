package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Data
@NoArgsConstructor
public class Member {
//	create table reactmember(
//		id varchar(50),
//		pw varchar(50),
//		name varchar(50),
//		season varchar(50)
//	)
	
	@NonNull
	private String id;
	@NonNull
	private String pw;
	private String name;
	private String season;
	private String role;
}
