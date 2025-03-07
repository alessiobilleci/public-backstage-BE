package it.backstage.service;

import org.springframework.stereotype.Service;

import it.backstage.vo.TestVO;

@Service
public class TestService {

	
	public TestVO exampleService(String nome, String cognome, long age) {
		TestVO vo= new TestVO();
		vo.setName(nome);
		vo.setSurname(cognome);
		vo.setAge(age);
		return vo;
	}
}
