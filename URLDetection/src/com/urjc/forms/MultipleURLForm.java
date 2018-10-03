package com.urjc.forms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.urjc.dto.URL;

public class MultipleURLForm {
	
	private static final String FIELD_URL       = "doc";
	private static final String URL_REGEX =
            "^((((http?|https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                    "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)" + "([).!';/?:, ][[:blank:]])?$";
	private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	public static final String QUOTE="\"";
	
	private String resultat;
    private Map<String, String> erreurs         = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }
    
    public URL createURL(HttpServletRequest request) throws IOException {
    	
    	String path = getFieldValue(request, FIELD_URL);
    	
    	URL url = new URL();
    	
    	List<String> urls = readURLs(path);
    	List<String> tags = readTags(path);
    	
		return null;
    	    	
    }
    
    private String getFieldValue(HttpServletRequest request, String fieldName) {
    	
        String value = request.getParameter(fieldName);
        if (value == null || value.trim().length() == 0) {
        	
            return null;
            
        } else {
        	
            return value;
            
        }
    }
    
    private List<String> readURLs(String path) throws IOException{
    	
    	BufferedReader br = null;
    	List<String> urls = new ArrayList<>();
    	
    	try {
            
            br =new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while (null!=line) {
               String [] fields = line.split(",");
               
               fields = removeTrailingQuotes(fields);
               
               urls.add(fields[0]);
               line = br.readLine();
            }
            
         } catch (Exception e) {
            
         } finally {
            if (null!=br) 
               br.close();
         }
    	return urls;
    }
    
    private List<String> readTags(String path) throws IOException{
    	
    	BufferedReader br = null;
    	List<String> tags = new ArrayList<>();
    	
    	try {
            
            br =new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while (null!=line) {
               String [] fields = line.split(",");
               
               fields = removeTrailingQuotes(fields);
               
               tags.add(fields[1]);
               line = br.readLine();
            }
            
         } catch (Exception e) {
            
         } finally {
            if (null!=br) 
               br.close();
         }
    	return tags;
    }

    private String[] removeTrailingQuotes(String[] fields) {

        String result[] = new String[fields.length];

        for (int i=0;i<result.length;i++){
           result[i] = fields[i].replaceAll("^"+QUOTE, "").replaceAll(QUOTE+"$", "");
        }
        return result;
     }
}
