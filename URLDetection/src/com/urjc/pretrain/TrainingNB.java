package com.urjc.pretrain;

import java.io.FileNotFoundException;
import java.io.IOException;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.NominalPrediction;
import weka.core.FastVector;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.supervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.ReplaceMissingValues;
import weka.filters.unsupervised.attribute.StringToNominal;

public class TrainingNB {
	
	public static final String FILENAME = "D:/Profiles/dbodasamaro/eclipse-workspace/URLDetection/WebContent/WEB-INF/data/data.arff";
	
	public static Instances readDataFile() throws IOException {
		
		Instances data = null;
		
		try {
		
			DataSource source = new DataSource(FILENAME);
			data = source.getDataSet();
			if (data.classIndex() == -1)
				data.setClassIndex(data.numAttributes() - 1);
			
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + FILENAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		return data;
	}
 
	public static double calculateAccuracy(FastVector predictions) {
		double correct = 0;
 
		for (int i = 0; i < predictions.size(); i++) {
			NominalPrediction np = (NominalPrediction) predictions.elementAt(i);
			if (np.predicted() == np.actual()) {
				correct++;
			}
		}
 
		return 100 * correct / predictions.size();
	}
 
	public static void main(String[] args) throws Exception {
				
		Instances data = readDataFile();;
		data.setClassIndex(data.numAttributes() - 1);
		
		int size = data.numInstances() / 10;

	    int begin = 0;
	    int end = size - 1 ;
			
		Instances training = new Instances(data);
        Instances testing = new Instances(data, begin , (end - begin));
	        
		Classifier tree = new NaiveBayes();
        StringToNominal nominal ;
	        
        for(int a=0;a<training.numAttributes()-1;a++){
        	
            if(training.attribute(a).isString()){
            	
                nominal = new StringToNominal();
                nominal.setAttributeRange("first-last");
                nominal.setInputFormat(training);	                
                training = Filter.useFilter(training, nominal);
	                
                NominalToBinary ntb = new NominalToBinary();
                ntb.setInputFormat(training);
                training = Filter.useFilter(training, ntb);
                
                ReplaceMissingValues m_MissingFilter = new ReplaceMissingValues();
                m_MissingFilter.setInputFormat(training);
                training = Filter.useFilter(training, m_MissingFilter);
            }
        }
	        
        tree.buildClassifier(training);
        Evaluation eval = new Evaluation(testing);

        eval.evaluateModel(tree, testing); 
        FastVector predictions = new FastVector<>();
        
        predictions.appendElements(eval.predictions());
        
        double accuracy = calculateAccuracy(predictions);
        
		// Print current classifier's name and accuracy in a complicated,
		// but nice-looking way.
		System.out.println("Accuracy of " + tree.getClass().getSimpleName() + ": "
							+ String.format("%.2f%%", accuracy)
							+ "\n---------------------------------");
			
        System.out.println("Precision:" + eval.precision(1));
        System.out.println("Recall:" + eval.recall(1));
        System.out.println("Fmeasure:" + eval.fMeasure(1));
        System.out.println("Error:" + eval.errorRate());

	}
			 
}
