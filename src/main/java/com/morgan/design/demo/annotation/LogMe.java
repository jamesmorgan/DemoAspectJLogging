package com.morgan.design.demo.annotation;

/**
 * @author james.morgan
 */
public @interface LogMe {
	public LoggingLevel value() default LoggingLevel.DEBUG;
}
