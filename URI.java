package DSPSU;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class URI {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = null;

		br = new BufferedReader(new InputStreamReader(System.in));			

		String s = br.readLine();
		
		int loopCount = Integer.parseInt(s);
		String result ="";
			
		for(int index=0; index<loopCount; index++){
			s = br.readLine();
			s = validateString(s);
			result += s +"\n";
		}
		System.out.print(result);
	}
	
	public static String validateString(String s){
		s = s.replace("%20"," ").replace("%21", "!").replace("%24", "$").replace("%28", "(").replace("%29", ")").replace("%2a", "*").replace("%25", "%");
		return s;
	}
}


