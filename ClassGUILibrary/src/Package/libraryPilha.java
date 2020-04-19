package Package;

import java.util.Stack;

import javax.swing.JOptionPane;

public class libraryPilha {
	
	private static Stack<String> pilha = new Stack<String>();
	private static Stack<String> saida = new Stack<String>();
	
	public static void nonTerminalClass(/*String posicao,*/Object sentenca) {
		//if (validations(sentenca.toString()) == false) return;
		try {
			//sentenca = sentenca.replaceAll(" ", "");
			//String[] sentencaSplit = {"teste"}; //sentenca.toString().split("->");
			//sentencaSplit = sentenca.toString().split("|");
			
			String se = sentenca.toString();
			
			if(se.startsWith("S")) {
				se = se.replaceAll(" ", "");
				String[] sentencaSplit = se.split("->");
				sentencaSplit = se.split("|");
				
				for(int i = se.length()-1; i >= 0 ; i--) {
					String t = sentencaSplit[i];
					pilha.push(t);
					if (t.contains("-") || (t.contains(">"))) {
						pilha.pop();
					}
					if(pilha.peek().toUpperCase() == t) {
						if(!pilha.isEmpty()) {
							pilha.pop();
							if(t.toLowerCase() == t) {
								saida.push(t);
							}else {
								
							}
			        	}
					}else {
						JOptionPane.showMessageDialog(null, "Nao Terminal Invalido");
						return;
					}
				}	
				
				while(!pilha.empty()) {
		            System.out.println("[" + pilha.pop() + "]");
		        }
			}
			
			
			/*for(int i = 0; i<sentenca.; i++) {
				String t = sentencaSplit[i];
				pilha.push(t);
				if (t.contains("-") || (t.contains(">"))) {
					pilha.pop();
				}	
				while(!pilha.empty()) {
		           // System.out.println("[" + pilha.pop() + "]");
		        }
				if(pilha.peek().toUpperCase() == t) {
					if (pilha.peek().equals("S")) {
						if(!pilha.isEmpty()) {
							pilha.pop();
							if(t.toLowerCase() == t) {
								saida.push(t);
							}else {
								
							}
								
			        	}
					}else {
						while(!pilha.empty()) {
				            System.out.println("[" + pilha.pop() + "]");
				        }
						return;
					}
				}else {
					JOptionPane.showMessageDialog(null, "Come�o Invalido");
					return;
				}
			}*/
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}

	}
	
	
	public static boolean validations(Object sentenca) {
		boolean ok = false;
		try {
			if (!sentenca.toString().contains("->")) {
				throw new Exception("Formato valido: X->Xx|Xx");
			}	
			return ok;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
			return ok=false;
		}
	}
}
