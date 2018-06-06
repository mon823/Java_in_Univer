package Ass_10;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame extends JFrame {

	JLabel Lab_1 = new JLabel("Love Java");

	MyFrame() {
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		setTitle("마우스 올리기 내리기");
		setSize(300, 200);
		setVisible(true);

		Lab_1.addMouseMotionListener(new MyMouseEvent());
		Lab_1.addMouseListener(new MyMouseEvent());
		JPanel panel = new JPanel();
		panel.add(Lab_1);
		container.add(Lab_1);

	}

	class MyMouseEvent implements MouseListener, MouseMotionListener {

		@Override
		public void mouseEntered(MouseEvent e) {
			Lab_1.setText("Love Java");

		}

		@Override
		public void mouseExited(MouseEvent e) {
			Lab_1.setText("사랑해");
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
}

public class Main_2_GUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// AWT 는 무거워
		// Swing 은 가벼워 + 기기영향을 잘 안받음
		// Flow, Border, Grid, Card (Layout)
		new MyFrame();
	}

}
