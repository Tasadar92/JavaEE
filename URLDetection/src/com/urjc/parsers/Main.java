package com.urjc.parsers;

import java.util.ArrayList;
import java.util.List;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import com.urjc.conection.ConexionJavaPython;

interface PyFunction{
    public List<String> getTokens(String url);
}
 
public class Main {
 
    public static void main(String[] args) {
    	
    	ConexionJavaPython conexion = new ConexionJavaPython();
    	
        PythonInterpreter interpreter = new PythonInterpreter();
        
        try {
            
        	interpreter.execfile("D:/Profiles/dbodasamaro/eclipse-workspace/URLDetection/src/com/urjc/parsers/Tokenizer.py");
            PyObject getTokens = interpreter.get("getTokens");
            PyFunction function =  (PyFunction) getTokens.__tojava__(PyFunction.class);
            List<String> tokens = new ArrayList<>();
            for(String s: function.getTokens("https://www.google.es"))
            	tokens.add(s);
            
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            e.toString();
        }finally {
        	interpreter.close();
		}
        
    }
 
}