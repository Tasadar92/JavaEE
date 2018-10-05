package com.urjc.parsers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Tokenizer {
	
	public List<String> tokenizer(String string) {
		
		String slash = "/";
		String hide = "-";
		String dot = ".";
		ArrayList<String> allTokens = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();
		
		string = deleteProtocol(string);
		
		StringTokenizer st = new StringTokenizer(string, slash);
		while(st.hasMoreElements())
			allTokens.add(st.nextToken());
		
		for(String s1: allTokens) {
			st = new StringTokenizer(s1, hide);
			while(st.hasMoreElements())
			temp.add(st.nextToken());
		}
		allTokens.addAll(temp);
		
		for(String s1: allTokens) {
			st = new StringTokenizer(s1, dot);
			while(st.hasMoreElements())
			temp.add(st.nextToken());
		}
		allTokens.addAll(temp);
		
		toSet_List(allTokens);
		
		return allTokens;
		
	}
	
	public List<Double> getLexicalFeatures(String url){
		
		List<Double> features = new ArrayList<>();
		String urlTemp = deleteProtocol(url);
		
		features.add((double) url.length());
		
		int x = urlTemp.indexOf(".")+1;
		
		if(urlTemp.contains("/")) {
			
			int y = urlTemp.indexOf("/")-1;		
			String primaryDomain = urlTemp.substring(x, y);
			features.add((double) primaryDomain.length());
			
		}else {
			
			String primaryDomain = urlTemp.substring(x);
			features.add((double) primaryDomain.length());
			
		}
		
		StringTokenizer dots = new StringTokenizer(urlTemp, ".");
		features.add((double) dots.countTokens());
		
		List<String> tokens = tokenizer(urlTemp);
		double cont = 0;
		int temp = 0;
		for(String s: tokens) {
			if(!s.contains(".")) {
				cont += s.length();
				if(temp < s.length())
					temp = s.length();
			}
			
		}
		
		features.add(cont/(tokens.size()-1));
		features.add((double) temp);
		
		return features;
		
	}
	
	private List<String> toSet_List(ArrayList<String> tokens) {
		
		Set<String> set = new HashSet<>();
		
		set.addAll(tokens);
		
		tokens.clear();
		for(String s: set)
			tokens.add(s);
		
		return tokens;
				
	}
	
	private String deleteProtocol(String string) {
		
		string = string.replaceFirst("http[s]?://", "");
		return string;
				
	}
	
}
