package Package;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainP {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new windowMain().setVisible(true);
	}
}
