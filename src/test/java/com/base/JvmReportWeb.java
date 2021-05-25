package com.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReportWeb {
		
		public static void generateReport(String JsonFile) {
			
			Configuration config = new Configuration(new File (System.getProperty("user.dir")+"/target/Results"), "DD book CLub  Automation report");
			config.addClassifications("Iteration", "1");
			config.addClassifications("Platform	", "Web");
			config.addClassifications("BrowserName", "Chrome");
			config.addClassifications("BrowserVersion", "90.0.4430.93");
			config.addClassifications("System Info", "Mac OS Catalina-10.15.7");

			List <String> JsonFiles = new ArrayList<String>();
			JsonFiles.add(JsonFile);
			ReportBuilder report = new ReportBuilder(JsonFiles, config);
			report.generateReports();
			 
		}
		

}
