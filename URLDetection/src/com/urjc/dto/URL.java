package com.urjc.dto;

import java.util.List;

public class URL {

	private String string;
	private List<String> features;
	private String tag;
	
	/**
	 * @return the string
	 */
	public String getString() {
		return string;
	}
	
	/**
	 * @param string the string to set
	 */
	public void setString(String string) {
		this.string = string;
	}
	
	/**
	 * @return the features
	 */
	public List<String> getFeatures() {
		return features;
	}
	
	/**
	 * @param features the features to set
	 */
	public void setFeatures(List<String> features) {
		this.features = features;
	}
	
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}	
	
}
