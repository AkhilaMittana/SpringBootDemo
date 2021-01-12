package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex1 {
		@RequestMapping("/")
		int add(){
			return 10;
		}
		
			@RequestMapping("/api1/add")
			public String add(int a, int b)
			{
				int c=a+b;
				return ("A="+a+" B= " + b + " Sum = :"+c);
				
				
			}
			@RequestMapping("/api1/sub")
			public String sub(int a,int b)
			{
				int c=a-b;
				return ("A= "+a+" B= "+b+" Sub= "+c);
			}
			@RequestMapping("/api1/mul")
			public String mul(int a,int b)
			{
				int c=a*b;
				return ("A= "+a+" B= "+b+" mul= "+c);
			}
			@RequestMapping("/api1/div")
			public String div(int a,int b)
			{
				double c=a/b;
				if(b==0)
				{
					return("cannot divide with zero");
				}
					else
				{
					c=(double)a/(double) b;
				return ("A= "+a+" B= "+b+" mul= "+c);
			    }
			}

		

}
