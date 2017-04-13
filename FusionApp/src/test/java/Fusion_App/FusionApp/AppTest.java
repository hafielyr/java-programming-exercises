package Fusion_App.FusionApp;


import static org.junit.Assert.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;




/**
 * 
 * @author trainee
 * Unit test for FusionApp
 */
public class AppTest 
{
	String inputFile1 = "random-nums.txt";
	String inputFile2 = "twitter-words.txt";
	String outputFile = "merged-file.txt";
	List<String> testWords = Arrays.asList("foo", "bar");
	@Test
	public void mergeFile() throws Exception {	

    	FileIO.mergeFile(inputFile1, inputFile2, outputFile);
		List<String> input1=Files.lines(Paths.get(inputFile1)).collect(Collectors.toList());
		List<String> input2=Files.lines(Paths.get(inputFile2)).collect(Collectors.toList());
		List<String> result = Files.lines(Paths.get(outputFile)).collect(Collectors.toList());
		assertNotNull(Paths.get(outputFile));
		assertEquals(result.get(0), input1.get(0));
		assertEquals(result.get(1), input1.get(1));
		assertEquals(result.get(input1.size()), input2.get(0));
		assertEquals(result.size(), input1.size()+input2.size());
	}
	@Test
	public void searchWord() throws Exception{
		String word1=FileIO.wordSearch(outputFile,s -> ((String) s).contains("O"),
				   s -> ((String) s).length() <= 5,s->((String) s).contains("W"));
		String word2=FileIO.wordSearch(inputFile1,s -> ((String) s).contains("O"),
				   s -> ((String) s).length() <= 5,s->((String) s).contains("W"));
		assertEquals(word1, "WOW!");
		assertEquals(word2, "not found");
		
	}
	@Test
	public void howManyCharacters() throws Exception{
		int characters1=FileIO.wordsInsideFileLength(inputFile1);
		int characters2=FileIO.wordsInsideFileLength(inputFile2);
		assertEquals(characters1,98);
		assertEquals(characters2,558);
		assertEquals(FileIO.wordsInsideFileLength(testWords.stream()), 6);
	}
}
