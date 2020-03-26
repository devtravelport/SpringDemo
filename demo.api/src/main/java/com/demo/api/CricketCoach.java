package com.demo.api;

public class CricketCoach implements Coach{

	//Now we will add FortuneService dependency in Coach implementation
	/**
	 * Here we will use setter injection
	 * 
	 */
	
	private FortuneService fortuneService;
	
	public CricketCoach() {
		System.out.println("Inside No-arg constructor: CricketCoach");
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "40 mins exercise - cricket coach";
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside setter method: CricketCoach");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getFortune() {
		//so here we are using that passed dependency from constructor
		//this helper class provides fortune logic to coach class
		return fortuneService.getFortune();
	}


	


}
