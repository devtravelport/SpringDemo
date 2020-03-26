package com.demo.api;

import org.springframework.core.io.ClassPathResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		
		/**
		 * This piece of code is basic java
		 * No spring concept yet
		 * Lets create an interface which other coaches can use
		 */
		//create the object		
		//BaseballCoach baseBallCoach = new BaseballCoach();//Why compilation error - cos when we added custom constructor than default constructor is no
		//longer in effect
		//So now java wnats us to add custom constructor here
		//This is old type of impl. So wen cosntructor got added in this class here it gives compilation errors
		//use the object
		//System.out.println(baseBallCoach.getDailyWorkout());
		/**
		 * New implementation using interface but still
		 * code needs to be modified everytime we want that impl to change
		 * 
		 */
		/*
		 * Coach theCoach = new BaseballCoach();
		 * System.out.println(theCoach.getDailyWorkout());
		 
		
		 theCoach = new TrackCoach();
		System.out.println(theCoach.getDailyWorkout());*/
		
		/**
		 * We want our Coach interface to be configurable using some kind of config file.
		 * So we are gonna use Spring Inversion of Control to make
		 * the above code configurable
		 * So we add applicationCOntext.xml and add the bean defination in there
		 * We will create context object first which can read from applicationContext.xml
		 */
		
		//load the spring configuration file
		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/**
		 * Behaves the same as getBean(String), 
		 * but provides a measure of type safety 
		 * by throwing a BeanNotOfRequiredTypeException 
		 * if the bean is not of the required type. 
		 * This means that ClassCastException 
		 * can't be thrown on casting the result correctly, 
		 * as can happen with getBean(String).
		 */
		
		Coach newCoach = springContext.getBean("myCoach", Coach.class);//IMPORTANT
		/**
		 * In the above line as we added contructor dependency of FortuneService
		 * It didn cause any prob. Here when spring gives back the bean it will give full thing so constructor is created and updated with
		 * fortune service's impl class which we defined in config file
		 */
		System.out.println("New Implementation***** "+newCoach.getDailyWorkout());
		System.out.println("New Implementation***** "+newCoach.getFortune());
		
		newCoach = springContext.getBean("swimCoach", Coach.class);
		System.out.println("New Implementation%%%% "+newCoach.getDailyWorkout());
		
		
		  newCoach = springContext.getBean("cricketCoach", Coach.class);
		  System.out.println("New Implementation**** "+newCoach.getDailyWorkout());
		 
		springContext.close();
	}

}
