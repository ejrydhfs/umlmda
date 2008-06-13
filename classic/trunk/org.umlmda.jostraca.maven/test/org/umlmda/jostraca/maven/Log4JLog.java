package org.umlmda.jostraca.maven;

import org.apache.log4j.Logger;
import org.apache.maven.plugin.logging.Log;

public class Log4JLog implements Log {
	private final Logger logger;
	
	public Log4JLog(Logger logger) {
		this.logger = logger;
	}

	public void debug(CharSequence message, Throwable t) {
		logger.debug(message, t);
	}

	public void debug(Throwable t) {
		logger.debug("", t);
	}

	public void debug(CharSequence message) {
		logger.debug(message);
	}

	public void error(CharSequence message, Throwable t) {
		logger.error(message, t);
	}

	public void error(Throwable t) {
		logger.error("", t);
	}

	public void error(CharSequence message) {
		logger.error(message);
	}

	public void info(CharSequence message, Throwable t) {
		logger.info(message, t);
	}

	public void info(Throwable t) {
		logger.info("", t);
	}

	public void info(CharSequence message) {
		logger.info(message);
	}

	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	public boolean isErrorEnabled() {
		return true;
	}
	
	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	public boolean isWarnEnabled() {
		return true;
	}

	public void warn(CharSequence message, Throwable t) {
		logger.warn(message, t);
	}

	public void warn(Throwable t) {
		logger.warn("", t);
	}

	public void warn(CharSequence message) {
		logger.warn(message);
	}
	

}
