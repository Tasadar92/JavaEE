package com.urjc.tokenizer;

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
