/**
 * 
 */
package org.umlmda.jostraca.maven;

import org.apache.maven.plugin.logging.Log;
import org.jostraca.util.UserMessageHandler;

/**
 * @author MOROFF
 *
 */
public class MavenUserMessageHandler implements UserMessageHandler {

	private final Log log;

	public MavenUserMessageHandler(Log log) {
		this.log = log;
	}
	
	/* (non-Javadoc)
	 * @see org.jostraca.util.UserMessageHandler#add(int, java.lang.String)
	 */
	public void add(int type, String msg) {
		switch (type) {
		case FATAL:
			fatal(msg);
			break;
		case ERROR:
			error(msg);
			break;
		case WARN:
			warn(msg);
			break;
		case INFO:
			info(msg);
			break;
		case DEBUG:
			debug(msg);
			break;
		}
	}

	/* (non-Javadoc)
	 * @see org.jostraca.util.UserMessageHandler#add(int, java.lang.String, java.lang.String)
	 */
	public void add(int type, String prefix, String msg) {
		add(type, prefix+": "+msg);
	}

	/* (non-Javadoc)
	 * @see org.jostraca.util.UserMessageHandler#debug(java.lang.String)
	 */
	public void debug(String msg) {
		log.debug(msg);
	}

	/* (non-Javadoc)
	 * @see org.jostraca.util.UserMessageHandler#debug(java.lang.Throwable)
	 */
	public void debug(Throwable pt) {
		log.debug(pt);
	}

	/* (non-Javadoc)
	 * @see org.jostraca.util.UserMessageHandler#debug(java.lang.String, java.lang.Throwable)
	 */
	public void debug(String msg, Throwable pt) {
		log.debug(msg, pt);
	}

	/* (non-Javadoc)
	 * @see org.jostraca.util.UserMessageHandler#debug(java.lang.String, java.lang.String)
	 */
	public void debug(String prefix, String msg) {
		debug(prefix+": "+msg);
	}

	public void error(String arg0, Throwable arg1) {
		log.error(arg0, arg1);
	}

	public void error(String arg0) {
		log.error(arg0);
	}

	public void error(Throwable arg0) {
		log.error(arg0);
	}

	/* (non-Javadoc)
	 * @see org.jostraca.util.UserMessageHandler#error(java.lang.String, java.lang.String)
	 */
	public void error(String prefix, String msg) {
		debug(prefix+": "+msg);
	}

	/* (non-Javadoc)
	 * @see org.jostraca.util.UserMessageHandler#fatal(java.lang.String)
	 */
	public void fatal(String msg) {
		error(msg);
	}

	/* (non-Javadoc)
	 * @see org.jostraca.util.UserMessageHandler#fatal(java.lang.Throwable)
	 */
	public void fatal(Throwable pt) {
		error(pt);
	}

	/* (non-Javadoc)
	 * @see org.jostraca.util.UserMessageHandler#fatal(java.lang.String, java.lang.Throwable)
	 */
	public void fatal(String msg, Throwable pt) {
		error(msg, pt);
	}

	/* (non-Javadoc)
	 * @see org.jostraca.util.UserMessageHandler#fatal(java.lang.String, java.lang.String)
	 */
	public void fatal(String prefix, String msg) {
		info(prefix+": "+msg);
	}


	public void info(String arg0, Throwable arg1) {
		log.info(arg0, arg1);
	}

	public void info(String arg0) {
		log.info(arg0);
	}

	public void info(Throwable arg0) {
		log.info(arg0);
	}

	/* (non-Javadoc)
	 * @see org.jostraca.util.UserMessageHandler#info(java.lang.String, java.lang.String)
	 */
	public void info(String prefix, String msg) {
		info(prefix+": "+msg);
	}

	/* (non-Javadoc)
	 * @see org.jostraca.util.UserMessageHandler#setThreshold(int)
	 */
	public void setThreshold(int threshold) {
		// TODO Auto-generated method stub

	}


	public void warn(String arg0, Throwable arg1) {
		log.warn(arg0, arg1);
	}

	public void warn(String arg0) {
		log.warn(arg0);
	}

	public void warn(Throwable arg0) {
		log.warn(arg0);
	}

	/* (non-Javadoc)
	 * @see org.jostraca.util.UserMessageHandler#warn(java.lang.String, java.lang.String)
	 */
	public void warn(String prefix, String msg) {
		warn(prefix+": "+msg);
	}

}
