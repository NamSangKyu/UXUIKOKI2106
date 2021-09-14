package com.example.di;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DiProjectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DiProjectApplication.class, args);
		AnnotationConfigApplicationContext ctx 
				= new AnnotationConfigApplicationContext(AppContext.class);
		Greeting g1 = ctx.getBean("greeting",Greeting.class);
		System.out.println(g1.getId() + " " + g1.getContent());
		Greeting g2 = ctx.getBean("greeting",Greeting.class);
		System.out.println(g1.getId() + " " + g1.getContent());
		Greeting g3 = ctx.getBean("greeting",Greeting.class);
		System.out.println(g1.getId() + " " + g1.getContent());
		Greeting g4 = ctx.getBean("greeting",Greeting.class);
		System.out.println(g1.getId() + " " + g1.getContent());
	}

}
