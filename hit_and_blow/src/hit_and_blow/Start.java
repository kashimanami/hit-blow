package hit_and_blow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Start {

	public static void main(String[] args) throws IOException {
		
		
		
		
		//title and rules
		System.out.println("Hit & Blow");
		System.out.println("You guess three numbers that be hided.\n"
							+"One number is the number from 1 to 5.\n"
							+"Three answers are not the same number.\n"
							+"\"Hit\" if the position of the entered number and the answer number hit and numbers is the same.\n"
							+"\"Blow\" if the numbers is only same.\n"
							+"Goal is \"3Hit\".\n"
							+"Start!\n");
		
		ArrayList<Integer> goalList = createGoaList();
		
		int hit = 0;
		
		while(hit<3) {
			ArrayList<Integer> inputList = createInputList();
		
			judgment(inputList,goalList);
		 }


		
	}
	
	//create random three numbers from 1 to 5
	private static ArrayList<Integer> createGoaList() {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for (int i = 1; i<=5; i++) {
			intList.add(i);
		}
		Collections.shuffle(intList);
		ArrayList<Integer> goalList = new ArrayList<Integer>();
		goalList.add(intList.get(0));
		goalList.add(intList.get(1));
		goalList.add(intList.get(2));
		System.out.println(goalList);
		return goalList;
	}
	
	//create the entered numbers
	private static ArrayList<Integer> createInputList() throws IOException {
		 System.out.println("Input three numbers on console.");
		 InputStreamReader isr = new InputStreamReader(System.in);
		 BufferedReader br = new BufferedReader(isr);
		 String inputStr = br.readLine();
		 int inputStrLength = inputStr.length();
		 ArrayList<Integer> inputList = new ArrayList<Integer>();
		 inputList.add(Integer.parseInt(inputStr.substring(0,1)));
		 inputList.add(Integer.parseInt(inputStr.substring(1,2)));
		 inputList.add(Integer.parseInt(inputStr.substring(2,3)));
		 inputList.add(inputStrLength);
		 return inputList;
	}
	
	//judgement
	private static void judgment(ArrayList<Integer> inputList,ArrayList<Integer> goalList) {
		//judge errors
		int hit = 0;
		int blow = 0; 
		if(inputList.get(3)<=2 || 4<=inputList.get(3)
				 || 6<=inputList.get(0) || 6<=inputList.get(1) || 6<=inputList.get(2)) {
			 System.out.println("Answer is three numbers from 1 to 5!");
		 }else {
			 // judge hit&blow
			 hit = 0;
			 blow = 0;
			 for (int i = 0; i < goalList.size(); i++) {
				 for (int j = 0; j < inputList.size(); j++) {
					 if (i == j && goalList.get(i) == inputList.get(j)) {
						 hit++;
					 } else if (goalList.get(i) == inputList.get(j)) {
						 blow++;
					 }
				 }
			 }
			 System.out.println("Hit"+hit+":Blow"+blow);
		 }
		 if(hit==3) {
				System.out.println("Goal！");
			}
	}
	
}
