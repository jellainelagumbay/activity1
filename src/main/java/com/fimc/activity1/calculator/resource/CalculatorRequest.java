package com.fimc.activity1.calculator.resource;

	import java.io.Serializable;

	import lombok.EqualsAndHashCode;
	import lombok.Getter;
	import lombok.Setter;

	@Getter
	@Setter
	@EqualsAndHashCode
	public class CalculatorRequest implements Serializable{
		private String operator;
		private String number1;
		private String number2;
	}

