package it.backstage.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestVO implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String surname;
	private long age;

}
