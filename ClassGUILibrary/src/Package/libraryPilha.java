package Package;

import java.util.Stack;

import javax.swing.JOptionPane;

public class libraryPilha {
	
	private static Stack<String> pilha = new Stack<String>();
	
	public static void nonTerminalClass(String sentenca) {
		validations(sentenca);
		boolean ok;
		try {
			sentenca = sentenca.trim().replaceAll(" ", "");
			
			/*
			 * no caso essa PrimeirasilabaNAOterminal 
			 * seria a silaba antes do "->" assim 
			 * verifica as letras maiusculas 
			 */
			String[] PrimeirasilabaNAOterminal = sentenca.split("->");
			
			for(int i = PrimeirasilabaNAOterminal.length-1 ; i>=0; i--) {
				String t = PrimeirasilabaNAOterminal[i];
				if (t.toUpperCase() == t) {
					System.out.println("Nao terminais: " + t);
					pilha.push(t);
				}
			}
			
		
			/*
			 * restante da sentencas
			 */

			String[] sentencas = sentenca.split("|");
			
			for(int in = 0; in<=sentencas.length-1; in++) {
				String set = sentencas[in];
				if (set.toUpperCase() == set) {
					pilha.push(set);
				}
				if (set.toLowerCase() == set){					
					pilha.push(set);	
				}
				if (set.contains("-") || (set.contains(">"))) {
					pilha.pop();
				}
			}
	        while(!pilha.empty()) {
	            System.out.println("[" + pilha.pop() + "]");
	        }
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
			ok = false;
		}

	}
	
	
	public static void validations(String sentenca) {
		try {
			if (!sentenca.contains("->")) {
				throw new Exception("Formato Inv�lido");
			}	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
	}
}
