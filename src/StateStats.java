/*Name: Xianhui Feng
	Course: CS 111B
	CRN: 71755
	Assignment: StateStats.java
	Date:11/30/2013
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;


public class StateStats {

	public static void main(String[] args) throws IOException {
		
		String file1 = "AbbrevPop.csv";
		String file2 = "StateAbbrev.csv";
		
		//create four arraylist hold abbreviation, populaiton, name and percentagae of populaiton
		ArrayList<String> abbList = new ArrayList<>();		
		ArrayList<String> popList = new ArrayList<>();
		ArrayList<String> nameList = new ArrayList<>();
		ArrayList<Float> perList = new ArrayList<>();
		
		//create File objects fileAP and fileSA
		File fileAP = new File(file1);
		File fileSA = new File(file2);
		
		//Create Scanner objects inputFileAP and inputFileSA
		Scanner inputFileAP = new Scanner(fileAP);
		Scanner inputFileSA = new Scanner(fileSA);

		//readFile
		readFile(inputFileAP, abbList, popList);
		readFile(inputFileSA, nameList, abbList);
		
		//Create RandomWAccessFile oject ppa pass PopPercentAlpha.dat file into construtor
		RandomAccessFile ppa = new RandomAccessFile("PopPercentAlpha.dat", "r");
		
		//read file and add file to perList
		boolean endOfFile = false;
		while(endOfFile == false){
			try{
					perList.add(ppa.readFloat());	
			}
			catch(EOFException e){
				endOfFile = true;
			}
		}

		//create csv file
		String sap = "StateAbbPop.csv";
		BufferedWriter writer = new BufferedWriter(new FileWriter(sap));
		for(int i = 0; i+1 < nameList.size(); i++){
			String content = nameList.get(i+1) +","+ abbList.get(i+1)+","+ popList.get(i+1)+","+perList.get(i).toString();
			writer.write(content);
			writer.newLine();
		}	 
		writer.close();
		
		//read csv file
		try (BufferedReader br = new BufferedReader(new FileReader(sap)))
		{
 
			String sCurrentLine;
 
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);

				
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} 

		
		//Create and populate State object
		State newState = new State(nameList, abbList, popList, perList);
		
		//Create and populate ListForm
		ListForm newList = new ListForm(newState);
	}
	
	/**
	 * readFile method reads file
	 * @param input
	 * @param token1
	 * @param token2
	 */
	public static void readFile(Scanner input, ArrayList<String> token1, ArrayList<String> token2){

		if(!input.hasNext()) return;
		StringTokenizer tokens = new StringTokenizer(input.nextLine(),",");
		token1.add(tokens.nextToken());
		token2.add(tokens.nextToken());
		readFile(input, token1, token2);
	}
	
}
