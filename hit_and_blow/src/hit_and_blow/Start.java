package hit_and_blow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Start {

	public static void main(String[] args) throws IOException {
		
		
		
		
		// タイトル表示＆ルール説明
		System.out.println("Hit & Blow");
		System.out.println("隠された3つの数字をあてます。\n"
							+"1つの数字は1から5の間です。\n"
							+"3つの答えの中に同じ数字はありません。\n"
							+"入力した数字の\n"
							+"位置と数字が当たってたらヒット、\n"
							+"数字だけあってたらブローとカウントします。\n"
							+"全部当てたら(3つともヒットになったら)\n"
							+"終了です。\n");
		
		// ランダム3文字生成
		ArrayList<Integer> goalList = createGoaList();
		
		//初期化
		int hit = 0;
		
		
		while(hit<3) {
			ArrayList<Integer> inputList = createInputList();
		
			judgment(inputList,goalList);
		 }


		
	}
	
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
	private static ArrayList<Integer> createInputList() throws IOException {
		 System.out.println("数字を入力してください。");
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
	
	private static void judgment(ArrayList<Integer> inputList,ArrayList<Integer> goalList) {
		//エラー判定
		int hit = 0;
		int blow = 0; 
		if(inputList.get(3)<=2 || 4<=inputList.get(3)
				 || 6<=inputList.get(0) || 6<=inputList.get(1) || 6<=inputList.get(2)) {
			 System.out.println("答えは1～5の数字3つです。");
		 }else {
			 // ヒットブロー判定
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
			 System.out.println("ヒット"+hit+"ブロー"+blow);
		 }
		 if(hit==3) {
				System.out.println("クリア！");
			}
	}
	
}