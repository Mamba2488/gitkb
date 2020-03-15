package my;
import javax.swing.*;
public class SwingDemo {
    private static void creatGui() {
    	MyFrame1 frame=new MyFrame1("SwingDemo");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(400,300);
    	frame.setVisible(true);
    	
    }
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				creatGui();
			}
		});


	}

}
