package com.ab0529.SpringJavaConfig;

import com.ab0529.SpringJavaConfig.models.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJavaConfigApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		Student student = (Student) context.getBean("Student");

		System.out.println(student);
	}

}
