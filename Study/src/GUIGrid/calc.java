package GUIGrid;

import java.awt.*;

import javax.swing.*;


public class calc extends JFrame{
	public calc() {
	setTitle("계산기");
	Container c = getContentPane();
	setLayout(new FlowLayout(FlowLayout.LEFT)); // 순차적으로 값을 넣어줌 왼쪽부터
	JLabel jl1 = new JLabel("수식 입력");
	c.add(jl1,"North");
	JTextField jtf1 = new JTextField(17);
	c.add(jtf1);
	c.add(new CPanel());
	c.add(new SPanel());
	setSize(300,200);
	setVisible(true);
	}

	class CPanel extends JPanel{
		public CPanel() {
			setLayout(new GridLayout(2,3,5,5));//행부터 맞춤
			JButton Jb1 = new JButton("0");
			this.add(Jb1);
			JButton Jb2 = new JButton("1");
			this.add(Jb2);
			JButton Jb3 = new JButton("2");
			this.add(Jb3);
			JButton Jb4 = new JButton("3");
			this.add(Jb4);
			JButton Jb5 = new JButton("4");
			this.add(Jb5);
			JButton Jb6 = new JButton("5");
			this.add(Jb6);
		}
	}
	
	class SPanel extends JPanel{
		public SPanel() {
			setBackground(Color.YELLOW);
			JLabel jl1 = new JLabel("계산 결과");
			add(jl1);
			JTextField jtf1 = new JTextField(17);
			add(jtf1);
		}
	}
		
}
