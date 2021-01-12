package com.example.demo.arithmetic;

import org.springframework.stereotype.Service;

@Service
public class DivServices {
	public String division(Arithemetic numbers) {
		int a = numbers.getNumber1();
		int b = numbers.getNumber2();
		int c;
		if(b == 0) {
			try {
				c = a/b;
			}catch(ArithmeticException e) {
				return e.getMessage()+" Denominator should not be zero";
			}
		}
		c = a/b;
		return("A= "+a+" B= "+b+" division= "+c);
	}
}
