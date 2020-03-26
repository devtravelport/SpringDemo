package com.demo.api;

/**
 *Adding this new interface which will be used by Coach interface.
 *Thus we will see how this dependency is injected in Coach
 * @author meenu.haseen
 *
 */
public interface FortuneService {
	
	public String getFortune();

}
