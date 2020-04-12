package Package;

import java.util.Stack;

import javax.swing.JOptionPane;

public class libraryPilha {
	
	private static Stack<String> pilha = new Stack<String>();
	private static Stack<String> saida = new Stack<String>();
	
	public static void nonTerminalClass(String posicao,String sentenca) {
		if (validations(sentenca) == false) return;
		try {
			sentenca = sentenca.trim().replaceAll(" ", "");
			String[] sentencaSplit = sentenca.split("->");
			sentencaSplit = sentenca.split("|");
			
			for(int i = sentencaSplit.length-1 ; i>=0; i--) {
				String t = sentencaSplit[i];
				pilha.push(t);
				if (t.contains("-") || (t.contains(">"))) {
					pilha.pop();
				}	
				if (pilha.peek().equals("S")) {
					if(!pilha.isEmpty()) {
						pilha.pop();
						if(t.toLowerCase() == t) {
							saida.push(t);
						}
		        	}
				}else {
					while(!pilha.empty()) {
			            System.out.println("[" + pilha.pop() + "]");
			        }
					return;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}

	}
	
	
	public static boolean validations(String sentenca) {
		boolean ok = false;
		try {
			if (!sentenca.contains("->")) {
				throw new Exception("Formato valido: X->Xx|Xx");
			}	
			return ok;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
			return ok=false;
		}
	}
}
