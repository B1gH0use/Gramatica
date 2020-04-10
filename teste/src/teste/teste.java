package teste;

import java.util.Stack;

public class teste {

	private static Stack<Integer> camarao = new Stack<Integer>();
	
	public static void nonTerminalClass(String sentenca) {
		
		sentenca = sentenca.trim().replaceAll(" ", "");
		
		String[] Start = sentenca.split("->");

		for(int i = Start.length-1 ; i>=0; i--) {
			String t = Start[i];
			if (t.equals("S")) {
				camarao.pus
			}	
		}
		
		
	   	//Stack<String> pilhaSentencas = new Stack<>();
		
		/*for (int i = sentencas.length-1 ; i>=0; i--){
			String t = sentencas[i];
		    if (!t.contentEquals("")) {  
		    	pilhaSentencas.push(t);
		        System.out.println(t);
		       // System.out.println(pilhaTokens);
		    }
		    
		}*/
	}
	
	public static void main(String[] args) {
		String sentenca = " S -> aA | ab ";
		nonTerminalClass(sentenca);
	}

}
