package com.urjc.conection;

import java.util.Properties;

import org.python.util.PythonInterpreter;

public class ConexionJavaPython {

	public ConexionJavaPython() {
		Properties props = new Properties();
    	props.put("python.home","D:/Profiles/dbodasamaro/eclipse-workspace/URLDetection/WebContent/WEB-INF/lib/Lib");
    	props.put("python.console.encoding", "UTF-8"); // Used to prevent: console: Failed to install '': java.nio.charset.UnsupportedCharsetException: cp0.
    	props.put("python.security.respectJavaAccessibility", "false"); //don't respect java accessibility, so that we can access protected members on subclasses
    	props.put("python.import.site","false");

    	Properties preprops = System.getProperties();
    			
    	PythonInterpreter.initialize(preprops, props, new String[0]);
    	
	}
	
}