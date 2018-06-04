package Swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton but_1 = new JButton("Action");
	but_1.addActionListener(new MyButtonListener());
	
	MyFrame(){
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		setTitle("11");
		setSize(300,300);
		setVisible(true);
		
		container.add(but_1);
		
	}
}
class MyButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		b.setBackground(Color.GREEN);
		
	}
	
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AWT 는 무거워
		//Swing 은 가벼워 + 기기영향을 잘 안받음
		//Flow, Border, Grid, Card (Layout)
		new MyFrame();
	}

}
