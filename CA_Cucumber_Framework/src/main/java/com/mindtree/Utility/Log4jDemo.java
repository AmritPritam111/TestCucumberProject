package com.mindtree.Utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

public class Log4jDemo {
	private Logger logger;
	@Test
	public void userLogin() {
		logger=Logger.getLogger("Log4jDemo.class");
		PropertyConfigurator.configure("./log4j.properties");
		System.out.println("\n Printing Logger messages \n");
		logger.trace("to trace the execution");
		logger.info("Browser launched");
		logger.error("it in not printed");
		logger.warn("printing warning messages");
		logger.fatal("It is a fatal defect");
		
		System.out.println("\n Printing Logger messages are completed \n");

}
}
