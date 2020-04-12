package Package;


import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
@SuppressWarnings("serial")
public class windowMain extends JDialog{

	Object[] rowgramatica = new Object[1];
	JTable tblGramatica;
	private JScrollPane spnGramatica;
	private DefaultTableModel tblModelGramatica = new DefaultTableModel() {public boolean isCellEditable(int row, int col) { return false;}};
	
	Object[] rowResutls = new Object[1];
	JTable tblResutls;
	private JScrollPane spnResutls;
	private DefaultTableModel tblModelResutls = new DefaultTableModel() {public boolean isCellEditable(int row, int col) { return false;}};
	
	private JLabel lblGramatica =  new JLabel();
	private JLabel lblPosition = new JLabel();
	
	private JTextField txfGramatica = new JTextField();
	private JTextField txfPosition = new JTextField();
	
	private JButton btnRandom = new JButton();
	private JButton btnOk = new JButton();
	private JButton btnSum = new JButton();
	private JButton btnRemove = new JButton();
	
	public windowMain() {
		setTitle("Deriva��o Gramatical");
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		buildWindows();
		actionsButtons();
		
	}
	
	private void buildWindows() {
		lblGramatica = new JLabel("Insira a gramatica");
		lblGramatica.setBounds(10, 10, 200, 25);
		lblGramatica.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblGramatica);
		
		lblPosition = new JLabel("Insira a Posi��o");
		lblPosition.setBounds(10, 45, 200, 25);
		lblPosition.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblPosition);
		
		txfGramatica = new JTextField();
		txfGramatica.setBounds(150, 10, 200, 25);
		txfGramatica.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfGramatica);
		
		txfPosition = new JTextField();
		txfPosition.setBounds(150, 45, 200, 25);
		txfPosition.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfPosition);
		
		btnRandom = new JButton("Random");
		btnRandom.setBounds(410, 45, 76, 24);
		btnRandom.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(btnRandom);
		
		btnOk= new JButton("OK");
		btnOk.setBounds(360, 45, 50, 24);
		btnOk.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(btnOk);
		
		btnSum= new JButton("+");
		btnSum.setBounds(360, 10, 50, 24);
		btnSum.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(btnSum);
		
		btnRemove = new JButton("-");
		btnRemove.setBounds(410, 10, 50, 24);
		btnRemove.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(btnRemove);

		tblModelGramatica.addColumn("Gram�ticas");
		tblGramatica = new JTable(tblModelGramatica);
		spnGramatica = new JScrollPane(tblGramatica);
		spnGramatica.setBounds(10, 80, 475, 167);
		getContentPane().add(spnGramatica);

		tblModelResutls.addColumn("Resultados");
		tblResutls = new JTable(tblModelResutls);
		spnResutls = new JScrollPane(tblResutls);
		spnResutls.setBounds(10, 260, 475, 200);
		getContentPane().add(spnResutls);		
	}
	
	private void actionsButtons() {
		btnOk.addActionListener(e->{
			String gramatica = txfGramatica.getText();
			String posicao = txfPosition.getText();
			System.out.println(posicao);
			for (int i = 0; i < tblModelGramatica.getRowCount(); i++){
				numdata.add(tblModelGramatica.getValueAt(i, 0).toString());
				libraryPilha.nonTerminalClass(posicao, numdata);
			}
			
		});
		
		btnSum.addActionListener(e->{
			rowgramatica[0] = txfGramatica.getText();
			tblModelGramatica.addRow(rowgramatica);
			txfGramatica.setText("");
		});
		
		btnRemove.addActionListener(e->{
			if (tblGramatica.getSelectedRow() >= 0){
				tblModelGramatica.removeRow(tblGramatica.getSelectedRow());
				tblGramatica.setModel(tblModelGramatica);
		    }else{
		        JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
		    }
		});
	}
	
}
