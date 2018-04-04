package pythonChallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class Counter {
	ArrayList<String> str = new ArrayList<String>();
	public static void main(String[] args) throws FileNotFoundException {
		Integer nextNum = 29;
		
			 URL url;
			 
		        while(true) {
		            // get URL content

		            String a= "" +nextNum;
		            

		            // open the stream and put it into BufferedReader
		            File f = new File("C:\\pchall\\" + a +".txt");
		            Scanner s = new Scanner(f);
		            
		            String inputLine = null;
		           
		            inputLine = s.nextLine();
		            System.out.println(inputLine);
		            String numText = inputLine.substring(inputLine.indexOf("nothing"));
		            System.out.println(numText);
		            nextNum = Integer.parseInt(numText.replaceAll("[^\\d.]", ""));
		            
		           

		            System.out.println(nextNum);
		        }
		        

		
		
	}
}