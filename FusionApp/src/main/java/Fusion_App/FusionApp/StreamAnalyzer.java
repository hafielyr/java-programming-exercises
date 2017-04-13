package Fusion_App.FusionApp;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;
/**
 * 
 * @author trainee
 * StreamAnalyzer interface
 * @param <T>
 */
public interface StreamAnalyzer<T> {
	T analyzeStream(Stream<String> strings);
	  /**
	   * method to execute a method with filename input
	   * @param filename
	   * @param analyzer
	   * @return T
	   */
	  public static <T> T analyzeFile(String filename, StreamAnalyzer<T> analyzer) {
	    try(Stream<String> lines = Files.lines(Paths.get(filename))) {
	      return(analyzer.analyzeStream(lines));
	    } catch(IOException ioe) {
	      System.err.println("Error reading file: " + ioe);
	      return(null);
	    }
	  }
}
