package com.example.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean //method is returning the beans
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			int beanCount = 0; // count the beans

			System.out.println("The following are the beans provided by SpringBoot:"); //beans are objects instantiated, assembled, and managed by a Spring IoC container

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
				beanCount++;
			}
			// show bean count
			System.out.println("There are " + beanCount + " beans :)");
			// gen random number
			int randBean = 0 + (int) (Math.random() * (beanCount-1));
			System.out.println("My favorite is " + beanNames[randBean]);
		};
	}

}
