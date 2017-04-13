package Fusion_App.FusionApp;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * Hello world!
 *
 */
/**
 * 
 * @author trainee
 * main class
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner userInput=new Scanner(System.in);
    	System.out.println("Enter 1 to merge file, 2 to search a word, 3 to count characters");
    	int input=userInput.nextInt();
    	//String inputFile1 = "random-nums.txt";
    	//String inputFile2 = "twitter-words.txt";
    	String outputFile = "merged-file.txt";
    	//merge 2 files into 1 file
    	if(input==1){
    		System.out.println("insert file 1 name (you can use default file input 'random-nums.txt')");
    		String inputFile1 = userInput.next();
    		System.out.println("insert file 2 name (you can use default file input 'twitter-words.txt')");
    		String inputFile2 = userInput.next();
        try {
			FileIO.mergeFile(inputFile1, inputFile2, outputFile);
			System.out.println("file "+outputFile+" created");
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    	}
        //search first word in file
    	if(input==2){
    	System.out.println("insert file name (you can use default file input 'twitter-words.txt') ");
        String inputFile = userInput.next();
        System.out.println("you can put as many as filter do you want, but unfortunately you should put in manually in the code");
        //you can put as many filters as do you want
        String word=FileIO.wordSearch(inputFile, s -> ((String) s).contains("O"),
				   s -> ((String) s).length() <= 5,s->((String) s).contains("W"));
        System.out.println(word);
    	}
        //find out how many character inside a file
    	if(input==3){
    	System.out.println("insert file name (you can use default file input 'twitter-words.txt')");
    	String inputFile = userInput.next();
        int charactes=FileIO.wordsInsideFileLength(inputFile);
        System.out.println(charactes);
    	}
    }
}
