package com.mitrais.cdc.java;

import java.util.*;
import java.util.function.*;

/** Some String-specific versions of methods that transform Lists. See
 *  ElementUtils for the better, generically-typed versions.
 */
/**
 * Class StringUtils
 * @author trainee
 *
 */
public class StringUtils {
	/**
	 * refactor method with predict
	 * @param candidates
	 * @param matchFunction
	 * @return List<string>
	 */
  public static List<String> allMatches(List<String> candidates, Predicate<String> matchFunction) {
	
    List<String> results = new ArrayList<>();
    
    //TODO: Question number one: return a new List of all the values that passed the test
    for(String c:candidates){
    	if(matchFunction.test(c)){
    		results.add(c);
    	}
    }
     
    
    return(results); 
  }
  
  /**
   * refactor method with predict
   * @param originals
   * @param transformer
   * @return List<String>
   */
  public static List<String> transformedList(List<String> originals, Function<String, String> transformer) {
    
	List<String> results = new ArrayList<>();
    
    //TODO: Question number three: return a new List that contains the results of applying the Function to each element of the original
	for(String o:originals){
		results.add(transformer.apply(o));
  }
	
    
    
    return(results); 
  }
  
  private StringUtils() {} // Uninstantiatable class
}
