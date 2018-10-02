package com.urjc.forms;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.urjc.dto.URL;

public class SingleURLForm {

	private static final String FIELD_URL       = "stringURL";
	private static final String URL_REGEX =
            "^((((http?|https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                    "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)" + "([).!';/?:, ][[:blank:]])?$";
	private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	
	private String resultat;
    private Map<String, String> erreurs         = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }
    
    public URL createURL(HttpServletRequest request) {
		
    	String string = getFieldValue(request, FIELD_URL);
    	
    	URL url = new URL();
    	
    	try {
            validationString(string);
        } catch (Exception e) {
            setError(FIELD_URL, e.getMessage());
        }
        url.setString(string);
    	
        if (erreurs.isEmpty()) {
        	resultat = "URL processed successfuly";
        } else {
        	resultat = "Unable to process the URL";
        }

        return url;
    	
    }
    
    private static String getFieldValue(HttpServletRequest request, String fieldName) {
    	
        String value = request.getParameter(fieldName);
        if (value == null || value.trim().length() == 0) {
        	
            return null;
            
        } else {
        	
            return value;
            
        }
    }
    
    private void validationString( String url ) throws Exception {
    	
    	if (url == null) {
    		throw new Exception( "Enter a valid URL" );
        }
    	
        Matcher matcher = URL_PATTERN.matcher(url);
        
        if(!matcher.matches())
        	if(!url.startsWith("http") || !url.startsWith("https") || !url.startsWith("ftps") || !url.startsWith("gopher") || !url.startsWith("telnet") || !url.startsWith("nntp"))
        		throw new Exception("Enter a URL with his protocol");
        	else
        		throw new Exception( "Enter a valid URL" );
    }
    
    private void setError( String champ, String message ) {
    	
    	erreurs.put( champ, message );
        
    }
}
