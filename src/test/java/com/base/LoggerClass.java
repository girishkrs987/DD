package com.base;
import org.apache.log4j.Logger;



public class LoggerClass {

    //Initialize Log4j logs

    private static Logger logger = Logger.getLogger(LoggerClass.class.getName());
    
    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

    public static void startTestCase(String sTestCaseName)

    {

    	logger.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");

   }



    //This is to print log for the ending of the test case

    public static void endTestCase(String sTestCaseName)

    {

    	logger.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");

//        Log.info("X");

//        Log.info("X");

//        Log.info("X");

//        Log.info("X");

   }



    // Need to create these methods, so that they can be called

    public static void info(String message) {

    	logger.info(message);

    }



    public static void warn(String message) {

    	logger.warn(message);

    }



    public static void error(String message) {

    	logger.error(message);

    }



    public static void fatal(String message) {

    	logger.fatal(message);

    }



    public static void debug(String message) {

    	logger.debug(message);

    }



}