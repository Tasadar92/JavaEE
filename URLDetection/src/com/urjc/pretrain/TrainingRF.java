package com.urjc.pretrain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.filters.Filter;
import weka.filters.supervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.StringToNominal;

public class TrainingRF {

	public static final String FILENAME = "D:/Profiles/dbodasamaro/eclipse-workspace/URLDetection/WebContent/WEB-INF/data/data.arff";
	private static Integer numFolds = 10;
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		
		Instances trainData = new Instances(br);
	    trainData.setClassIndex(trainData.numAttributes() - 1);
	    
	    RandomForest rf = new RandomForest();
	    rf.setNumFeatures(trainData.numAttributes());
	    
	    //You can set the options here
	    /*String[] options = new String[1];
	    options[0] = "-R";                
	    rf.setOptions(options);*/
	    
	    StringToNominal nominal = new StringToNominal();
        nominal.setAttributeRange("first-last");
        nominal.setInputFormat(trainData);	                
        trainData = Filter.useFilter(trainData, nominal);
            
        NominalToBinary ntb = new NominalToBinary();
        ntb.setInputFormat(trainData);
        trainData = Filter.useFilter(trainData, ntb);
        
	    rf.buildClassifier(trainData);
	    
	    weka.filters.supervised.attribute.AttributeSelection as = new  weka.filters.supervised.attribute.AttributeSelection();
	    Ranker ranker = new Ranker();
	    
	    InfoGainAttributeEval infoGainAttrEval = new InfoGainAttributeEval();
	    as.setEvaluator(infoGainAttrEval);
	    as.setSearch(ranker);
	    as.setInputFormat(trainData);
	    trainData = Filter.useFilter(trainData, as);
	    
	    Evaluation evaluation = new Evaluation(trainData);
	    evaluation.crossValidateModel(rf, trainData, numFolds, new Random(1));
	    
	    // Using HashMap to store the infogain values of the attributes 
	    int count = 0;
	    Map<String, Double> infogainscores = new HashMap<String, Double>();
	    
	    for (int i = 0; i < trainData.numAttributes(); i++) {
	    	String t_attr = trainData.attribute(i).name();
	    	System.out.println(i+trainData.attribute(i).name());
	    	double infogain  = infoGainAttrEval.evaluateAttribute(i);
	    	
	    	if(infogain != 0){
                System.out.println(t_attr +  "= "+ infogain); 
                infogainscores.put(t_attr, infogain);
                count = count+1;
	    	}
	    }
	    
	    //iterating over the hashmap
	    Iterator<Entry<String, Double>> it = infogainscores.entrySet().iterator();
	    while (it.hasNext()) {
	       Map.Entry pair = (Map.Entry)it.next();
	       System.out.println(pair.getKey()+"  =  "+pair.getValue());
	       System.out.println(pair.getKey()+"  =  "+pair.getValue());
	       it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
}
