package com.ab0529.SpringAnnotationConfig;

import com.ab0529.SpringAnnotationConfig.models.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringAnnotationConfigApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ab0529.SpringAnnotationConfig.models");
		context.refresh();

		Student student = (Student) context.getBean("Student");
		System.out.print(student);
	}

}
