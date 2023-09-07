package test2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		// Context init = new InitialContext();
		
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:context.xml");
		
		Hello ob1 = context.getBean(Hello.class);
		Hello ob2 = context.getBean("hello", Hello.class);
		
		System.out.println(ob1.getText());
		System.out.println(ob2.getText());
		System.out.println();
		
		System.out.println(ob1 == ob2);
		context.close();
	}
}
