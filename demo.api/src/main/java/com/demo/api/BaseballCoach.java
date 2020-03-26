package com.demo.api;

public class BaseballCoach implements Coach{

	//Now we will add FortuneService dependency in Coach implementation
	/**
	 * We can do constructor injection or Setter injection
	 * Lets see constructor injection first
	 * For this we will add this FortuneService in BaseballCoach class's 
	 * constructor
	 */
	
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;//Here constructor is being used to inject dependency 
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "30 mins exercise - baseball coach";
	}

	@Override
	public String getFortune() {
		//so here we are using that passed dependency from constructor
		//this helper class provides fortune logic to coach class
		return fortuneService.getFortune();
	}


	


}
