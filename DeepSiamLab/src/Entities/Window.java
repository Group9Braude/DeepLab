package Entities;

import javax.swing.JOptionPane;

/**
 * This class will provide the user with easy to use JOPtionPane windows methods.
 *
 */
public class Window {

	public static void warning(String str){
				JOptionPane.showMessageDialog(null, str, "Error",
						JOptionPane.ERROR_MESSAGE);
	}
	
	public static String input(String message, String title){
		return(JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE));
	}
/**
 * JOptionPane.YES_OPTION(0) - An integer that implies the response was positive. 
 * JOptionPane.NO_OPTION(1) - An integer that implies the response was negative.
 * @param message
 * @param title
 * @return
 */
	public static int yesNo(String message, String title){
		return(JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION));
	}

}
