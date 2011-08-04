package com.morgan.design.demo;

import org.springframework.stereotype.Component;

import com.morgan.design.demo.annotation.LogMe;
import com.morgan.design.demo.annotation.LoggingLevel;

/**
 * @author james.morgan
 */
@Component
public class LoggingExample {

	@LogMe
	public void logMe() {
		// do something in you method
	}

	@LogMe(LoggingLevel.INFO)
	public void logMeInfoWithMethodArgs(final String someStringArg, final int someIntArg) {
		// do something in you method
	}

	@LogMe(LoggingLevel.WARN)
	public void logMeWarningWithMethodArgs(final String someStringArg, final int someIntArg, final boolean someArgBoolean) {
		// do something in you method
	}

	@LogMe(LoggingLevel.DEBUG)
	public void logMeDebugWithMethodArgs(final String someStringArg, final int someIntArg, final boolean someArgBoolean,
			final float someArgFloat) {
		// do something in you method
	}

}
