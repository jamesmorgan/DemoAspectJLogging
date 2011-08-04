package com.morgan.design.demo.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

	private ILoggerFactory iLoggerFactory = LoggerFactory.getILoggerFactory();

	@Before("execution(@com.morgan.design.demo.annotation.LogMe(com.morgan.design.demo.annotation.LoggingLevel.WARN) * *(..))")
	public void loggerWarn(final JoinPoint jp) throws Throwable {
		final Logger logger = getLoggerForClass(jp);
		logger.warn(buildLogging(jp));
	}

	@Before("execution(@com.morgan.design.demo.annotation.LogMe(com.morgan.design.demo.annotation.LoggingLevel.DEBUG) * *(..))")
	public void loggerDebug(final JoinPoint jp) throws Throwable {
		final Logger logger = getLoggerForClass(jp);
		logger.debug(buildLogging(jp));
	}

	@Before("execution(@com.morgan.design.demo.annotation.LogMe(com.morgan.design.demo.annotation.LoggingLevel.INFO) * *(..))")
	public void loggerInfo(final JoinPoint jp) throws Throwable {
		final Logger logger = getLoggerForClass(jp);
		logger.info(buildLogging(jp));
	}

	private Logger getLoggerForClass(final JoinPoint jp) {
		return this.iLoggerFactory.getLogger(jp.getSignature()
			.getDeclaringType()
			.getName());
	}

	private String buildLogging(final JoinPoint jp) {
		final StringBuilder message = new StringBuilder();
		message.append("Method Invocation=[")
			.append(jp.getSignature()
				.getName())
			.append("]")
			.append(" - Args=")
			.append(Arrays.toString(jp.getArgs()));
		return message.toString();
	}
}
