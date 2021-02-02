package 자료구조;

import java.util.ArrayList;
import java.util.Scanner;

public class Mun_후위표기식2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		int[] arr = new int[n];
		ArrayList<String> al = new ArrayList<>();
		for(int i =0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0; i<s.length(); i++) {
			String val = String.valueOf(s.charAt(i));
			if(Character.isUpperCase(s.charAt(i))) {
				val = String.valueOf(arr[(s.charAt(i)-'A')]);
			}
			al.add(val);
		}
		
		
		while(al.size() !=1) {
			for(int i=0; i<al.size(); i++) {
				if(al.get(i).equals("*")) {
					double num1 = Double.parseDouble(al.get(i-2));
					double num2 = Double.parseDouble(al.get(i-1));
					al.remove(i-2);
					al.remove(i-2);
					al.remove(i-2);
					al.add(i-2, String.valueOf(num1*num2));
					break;
				}else if(al.get(i).equals("/")) {
					double num1 = Double.parseDouble(al.get(i-2));
					double num2 = Double.parseDouble(al.get(i-1));
					al.remove(i-2);
					al.remove(i-2);
					al.remove(i-2);
					al.add(i-2,String.valueOf(num1/num2));
					break;
				}else if(al.get(i).equals("+")) {
					double num1 = Double.parseDouble(al.get(i-2));
					double num2 = Double.parseDouble(al.get(i-1));
					al.remove(i-2);
					al.remove(i-2);
					al.remove(i-2);
					al.add(i-2,String.valueOf(num1+num2));
					break;
				}else if(al.get(i).equals("-")){
					double num1 = Double.parseDouble(al.get(i-2));
					double num2 = Double.parseDouble(al.get(i-1));
					al.remove(i-2);
					al.remove(i-2);
					al.remove(i-2);
					al.add(i-2,String.valueOf(num1-num2));
					break;
				}
			}
		}
		System.out.printf("%.2f", Double.valueOf(al.get(0)));
	}
}
