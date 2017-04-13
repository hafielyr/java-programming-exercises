package Fusion_App.FusionApp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * 
 * @author trainee
 * FileIO class, a class that has many methods
 */
public class FileIO {
	/**
	 * method to merge 2 files into 1
	 * @param inputFile1
	 * @param inputFile2
	 * @param outputFile
	 * @throws Exception
	 */
	 public static void mergeFile(String inputFile1,String inputFile2, String outputFile) throws Exception {
		  
		  Path pathInput1=Paths.get(inputFile1);
		  Path pathInput2=Paths.get(inputFile2);
		  Path output=Paths.get(outputFile);
		  List<String> lines1=Files.lines(pathInput1).collect(Collectors.toList());
		  List<String> lines2=Files.lines(pathInput2).collect(Collectors.toList());
		  try(BufferedWriter writer=Files.newBufferedWriter(output, Charset.defaultCharset())){
			  for(String l:lines1){
				  writer.write(l);
				  writer.newLine();
			  }
			  for(String l:lines2){
				  writer.write(l);
				  writer.newLine();
			  }
		  }
		  catch (IOException ioe) {
			  System.err.printf("IOException: %s%n", ioe);
		}
		  
	  }
	
	@SafeVarargs
	/**
	 * method to find word whit as many as parameters do you want
	 * @param fileName
	 * @param Tests
	 * @return String
	 */
	public static <T> String wordSearch(String fileName,Predicate<T>... Tests){
		 Predicate<T> filters = e -> true;
		    for(Predicate<T> test: Tests) {
		        filters = filters.and(test);
		    }
		 Path filePath=Paths.get(fileName);
		 String word="not found";
		try {
			word = Files.lines(filePath).filter((Predicate<? super String>) filters).findFirst().orElse("not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return word;
	 }
	/**
	 * method to count the character inside a file
	 * @param words
	 * @return int
	 */
	 public static int wordsInsideFileLength(Stream<String> words){
		 return words.mapToInt(s->s.length()).sum();
	 }
	 /**
	  * method to count the character inside a file
	  * @param fileName
	  * @return
	  */
	 public static int wordsInsideFileLength(String fileName){
		 return StreamAnalyzer.analyzeFile(fileName, FileIO::wordsInsideFileLength);
	 }
}
