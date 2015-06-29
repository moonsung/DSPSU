package DSPSU;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = null;

		br = new BufferedReader(new InputStreamReader(System.in));			

		String s = br.readLine();
		
		int loopCount = Integer.parseInt(s);
		String result ="";
			
		for(int index=0; index<loopCount; index++){
			s = br.readLine();
			if(validateBrackets(s)){
				result +="YES\n";
			}else{
				result +="NO\n";
			}
		}
		
		
		System.out.println(result);
		
		
	}
	
	public static Boolean validateBrackets(String s){
		/*
		 * 스택을 사용해서 open을 만나면 스택에 넣고, close를 만나면 스택에 있는 브라캣을 하나 꺼내서 매칭이 되는지 검증
		 * 예외처리 :: 한쪽만 나오는 경우
		 */
		Stack<Character> openStack = new Stack<Character>();
		
		for(int i=0; i<s.length(); i++){
			//open 브라켓이면 스택에 넣구여
			if(isOpenBracket(s.charAt(i))){
				openStack.push(s.charAt(i));
			}else{
				//close브라캣인경우, open브라켓 스택에 친구가 있으면
				if(!openStack.empty()){
					//꺼내서 매칭 되는지 보고 매칭이 안되면 검증 실패
					if(!matchingBrackets(openStack.pop(), s.charAt(i))){
						return false;
					}					
				}else{
					return false;
				}
			}
		}
		
		//스택에 브라켓이 남아 있으면 검증 실패 (예외처리)
		if(openStack.size() > 0){
			return false;
		}
		
		return true;
		
	}
	
	public static Boolean isOpenBracket(char s){
		
		//브라켓 케이스중, 오픈브라켓인지 검증
		
		if(s == 40){
			return true;
		}else if(s == 91){
			return true;
		}else if(s == 123){
			return true;
		}else{
			return false;
		}		
	}	
	
	public static Boolean matchingBrackets(int firstOne, int secondOne){
		
		//두개의 캐릭터가 open,close인지 검증
		
		if(firstOne == 40){
			if(secondOne == 41){
				return true;
			}else{
				return false;
			}
		}else if(firstOne == 91){
			if(secondOne == 93){
				return true;
			}else{
				return false;
			}
		}else if(firstOne == 123){
			if(secondOne == 125){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}


