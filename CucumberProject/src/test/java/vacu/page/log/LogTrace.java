package vacu.page.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTrace {
	private static Logger logger= LogManager.getLogger(Logger.class);
	
	public static void main(String [] args) {
		logger.info("LogTrace");
	}

	

}
