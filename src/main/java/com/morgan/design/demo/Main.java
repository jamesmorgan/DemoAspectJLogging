package com.morgan.design.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(final String[] args) {
		// Load spring config
		final ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");

		// Get me my spring managed bean
		final LoggingExample loggingExample = context.getBean(LoggingExample.class);

		try {
			// Invoke logging examples
			loggingExample.logMe();
			loggingExample.logMeInfoWithMethodArgs("abcdefg", 1234);
			loggingExample.logMeWarningWithMethodArgs("abcdefg", 1234, true);
			loggingExample.logMeDebugWithMethodArgs("abcdefg", 1234, false, 0.2F);
		}
		catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
