package ReversePolishNotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[])throws IOException{
		String enteredInfix = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Postfix postfix = new Postfix();
		while(true){
			try{
				enteredInfix = reader.readLine();				
				String outputPostfix = postfix.convert(enteredInfix);
				System.out.println(outputPostfix);
				System.out.println(postfix.evaluate(outputPostfix));
			}catch(NullPointerException e){
				 // Nothing was entered
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
