package com.ab0529.SpringXMLConfig;

import com.ab0529.SpringXMLConfig.models.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringXmlConfigApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		Student obj = (Student) context.getBean("Student");

		System.out.println(obj);

	}

}
