package com.urjc.parsers;

import java.util.Properties;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

interface PyFunction{
    public void sumFunction(int a, int b);
}
 
public class Main {
 
    public static void main(String[] args) {
    	
    	Properties props = new Properties();
    	props.put("python.home","D:/Profiles/dbodasamaro/eclipse-workspace/URLDetection/WebContent/WEB-INF/lib/Lib");
    	props.put("python.console.encoding", "UTF-8"); // Used to prevent: console: Failed to install '': java.nio.charset.UnsupportedCharsetException: cp0.
    	props.put("python.security.respectJavaAccessibility", "false"); //don't respect java accessibility, so that we can access protected members on subclasses
    	props.put("python.import.site","false");

    	Properties preprops = System.getProperties();
    			
    	PythonInterpreter.initialize(preprops, props, new String[0]);
        PythonInterpreter interpreter = new PythonInterpreter();
        
        try {
            //interpreter.exec("from Tokenizer import sumOfNumbers");
        	interpreter.execfile("D:/Profiles/dbodasamaro/eclipse-workspace/URLDetection/src/com/urjc/parsers/Tokenizer.py");
            PyObject sumFunction = interpreter.get("sumOfNumbers");
            PyFunction function = (PyFunction) sumFunction.__tojava__(PyFunction.class);
            function.sumFunction(5, 10);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            e.toString();
        }finally {
        	interpreter.close();
		}
        
    }
 
}