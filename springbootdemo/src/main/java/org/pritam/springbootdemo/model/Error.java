package org.pritam.springbootdemo.model;

import lombok.Data;

@Data
public class Error {
	private int errorCode;
	private String description;
}
