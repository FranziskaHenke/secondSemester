package ReversePolishNotation;

public class Postfix {
	
	private Stack<String> stack; 
	
	
	public Postfix(){
		stack = new LinkedListStack<String>();
	}		

	public double evaluate(String postfix) {
		while(!postfix.equals("")){
			String t = String.valueOf(postfix.charAt(0));
			postfix = postfix.substring(1);
			if(isOperator(t)){
				double rhs = Double.parseDouble(stack.toString(stack.top()));
				stack.pop();
				double lhs = Double.parseDouble(stack.toString(stack.top()));
				stack.pop();
				String result = String.valueOf(calculate(lhs, rhs, t));
				stack.push(result);
			}else{
				stack.push(t);
			}
		}
		return Double.parseDouble(stack.toString(stack.top()));
	}
	
	public void enterStringIntoStack(String postfix){
		for(int i = 0;i<postfix.length(); i++){
			stack.push("" +postfix.charAt(postfix.length()-i-1));
		}
	}
	
	
	public double calculate(double leftNumber, double rightNumber, String operator){
		if(operator.equals("+"))
			return leftNumber + rightNumber;
		else if(operator.equals("-"))
			return leftNumber - rightNumber;
		else if(operator.equals("/"))
			return leftNumber / rightNumber;
		else if(operator.equals("*"))
			return leftNumber * rightNumber;
		else if(operator.equals("^"))
			return Math.pow(leftNumber, rightNumber);	
		else 
			return -1;
	}
	
	
	public boolean isOperator(String charToBeTested){
		if((charToBeTested.equals("+"))||(charToBeTested.equals("-"))||(charToBeTested.equals("*"))||(charToBeTested.equals("/"))||(charToBeTested.equals("^"))||(charToBeTested.equals("("))||(charToBeTested.equals(")"))){
			return true;
		}else{
			return false;
		}
	}
	
	public String convert(String infix){
		String result = "";
		while(!infix.equals("")){
			String t = String.valueOf(infix.charAt(0));
			infix = infix.substring(1);
			if(!isOperator(t)){
				result = result + t;
			}else if(t.equals("(")){
				stack.push(t);
			}else if(t.equals(")")){
				while(!stack.toString(stack.top()).equals("(")){
					result = result + stack.toString(stack.top());
					stack.pop();
				}
				stack.pop();			
			}else if(isOperator(t)){
				if(!stack.isEmpty()){
					while((!stack.isEmpty())&&(!stack.toString(stack.top()).equals("("))&&(!precedenceIsChecked(t, stack.toString(stack.top())))){
						result = result + stack.toString(stack.top());
						stack.pop();
					}
				}
				stack.push(t);
			
			}
		}while(!stack.isEmpty()){
			result = result + stack.top().getData();
			stack.pop();
		}
		return result;
	}
	
	public boolean precedenceIsChecked(String t, String top){
		if(((top.equals("+"))||(top.equals("-")))&&((t.equals("*"))||(t.equals("/")))){
			return true;
		}else if(((top.equals("*"))||(top.equals("/")))&&((t.equals("^")))){
			return true;
		}else if(((t.equals("+"))&&(t.equals("-")))||(top.equals("*"))&&(top.equals("/"))){
			return true;
		}else if(((top.equals("+"))||(top.equals("-")))&&(t.equals("^"))){
			return true;
		}else{
			return false;
		}

	}
	

}
