package aaa;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
    public static void main(String[] args) {
        MyFrame a = new MyFrame();
    } 
}

class MyFrame extends JFrame{

	
	
	//private static final long serialVersionUID = 11L;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	JButton bnt = new JButton(" 계산 ");
	
	
	JLabel label_1 = new JLabel("금액 ");
	JLabel lb2 = new JLabel("오만원");
	JLabel lb3 = new JLabel("만원");
	JLabel lb4 = new JLabel("천원");
	JLabel lb5 = new JLabel("500원");
	JLabel lb6 = new JLabel("100원");
	JLabel lb7 = new JLabel("50원");
	JLabel lb8 = new JLabel("10원");
	JLabel lb9 = new JLabel("1원");
	
	
	JPanel jp1 = new JPanel(); 
	JPanel jp2 = new JPanel(); 
	JPanel jp3 = new JPanel();
	JPanel jp4 = new JPanel();
	JPanel jp5 = new JPanel();
	JPanel jp6 = new JPanel();
	JPanel jp7 = new JPanel();
	JPanel jp8 = new JPanel();
	JPanel jp9 = new JPanel();
	JPanel jp10 = new JPanel();
	JPanel jp11 = new JPanel();
	
	JCheckBox cb1 = new JCheckBox();
	JCheckBox cb2 = new JCheckBox();
	JCheckBox cb3 = new JCheckBox();
	JCheckBox cb4 = new JCheckBox();
	JCheckBox cb5 = new JCheckBox();
	JCheckBox cb6 = new JCheckBox();
	JCheckBox cb7 = new JCheckBox();
	JCheckBox cb8 = new JCheckBox();
	
	JTextField text_1 = new JTextField(20);
	JTextField text_2 = new JTextField(20);
	JTextField text_3 = new JTextField(20);
	JTextField text_4 = new JTextField(20);
	JTextField text_5 = new JTextField(20);
	JTextField text_6 = new JTextField(20);
	JTextField text_7 = new JTextField(20);
	JTextField text_8 = new JTextField(20);
	JTextField text_9 = new JTextField(20);

	

	public MyFrame(){
        setSize(400, 800);//프레임 크기 설정
        setTitle("Money Changer with  CheckBox");
        this.setBackground(new Color(255,204,204));
        
        jp1.setLayout(new FlowLayout());
        jp1.add(label_1);
        jp1.add(text_1);
        jp1.add(bnt);
        
        this.add(jp1);
        
        this.setLayout(new GridLayout(9,9));
        cb1.setBackground(new Color(255,204,204));
        cb2.setBackground(new Color(255,204,204));
        cb3.setBackground(new Color(255,204,204));
        cb4.setBackground(new Color(255,204,204));
        cb5.setBackground(new Color(255,204,204));
        cb6.setBackground(new Color(255,204,204));
        cb7.setBackground(new Color(255,204,204));
        cb8.setBackground(new Color(255,204,204));
        
        
        
        jp1.setLayout(new FlowLayout());
        
        
        jp2.add(lb2);
        jp2.add(text_2);
        jp10.add(jp2);
        jp2.add(cb2);
        
        jp1.setLayout(new FlowLayout());
        
        
        jp3.add(lb3);
        jp3.add(text_3);
        jp10.add(jp3);
        jp3.add(cb3);
        
        jp1.setLayout(new FlowLayout());
        
        
        jp4.add(lb4);
        jp4.add(text_4);
        jp10.add(jp4);
        jp4.add(cb4);
        
        jp1.setLayout(new FlowLayout());
        
        
        jp5.add(lb5);
        jp5.add(text_5);
        jp10.add(jp5);
        jp5.add(cb5);
        
        jp1.setLayout(new FlowLayout());
        
        
        jp6.add(lb6);
        jp6.add(text_6);
        jp10.add(jp6);
        jp6.add(cb6);
        
        jp1.setLayout(new FlowLayout());
        
        
        jp7.add(lb7);
        jp7.add(text_7);
        jp10.add(jp7);
        jp7.add(cb7);
        
        jp1.setLayout(new FlowLayout());
        
        
        jp8.add(lb8);
        jp8.add(text_8);
        jp10.add(jp8);
        jp8.add(cb8);
        
        
        jp1.setLayout(new FlowLayout());
        
        jp9.add(lb9);
        jp9.add(text_9);
        jp10.add(jp9);
        
        jp1.setBackground(new Color(255,204,204));
        jp2.setBackground(new Color(255,204,204));
        jp3.setBackground(new Color(255,204,204));
        jp4.setBackground(new Color(255,204,204));
        jp5.setBackground(new Color(255,204,204));
        jp6.setBackground(new Color(255,204,204));
        jp7.setBackground(new Color(255,204,204));
        jp8.setBackground(new Color(255,204,204));
        jp9.setBackground(new Color(255,204,204));
        
        this.add(jp1,"North");
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);
        this.add(jp7);
        this.add(jp8);
        this.add(jp9);
        
//        button_Add.setBackground(new Color(0,255,255));
//        button_Sub.setBackground(new Color(0,255,255));
//        button_Mul.setBackground(new Color(0,255,255));
//        button_Div.setBackground(new Color(0,255,255));
//        
//		jpn_1.setBackground(new Color(204,204,204));
//		jpn_3.setBackground(new Color(255,255,0));
//		jpn_2.setBackground(new Color(255,255,255));
//        //setLayout(new FlowLayout());//기본설정BoderLayout 에서 FlowLayout으로 변경
//        jpn_1.add(label_1);
//        jpn_1.add(text_1);
//        this.add(jpn_1,"North");
//        
//        jpn_2.add(buttonStart_0);
//        buttonStart_0.addActionListener(this);
//        buttonStart_0.getInsets();
//        jpn_2.add(buttonStart_1);
//        buttonStart_0.addActionListener(this);
//        jpn_2.add(buttonStart_2);
//        buttonStart_0.addActionListener(this);
//        jpn_2.add(buttonStart_3);
//        buttonStart_0.addActionListener(this);
//        jpn_2.add(buttonStart_4);
//        buttonStart_0.addActionListener(this);
//        jpn_2.add(buttonStart_5);
//        buttonStart_0.addActionListener(this);
//        jpn_2.add(buttonStart_6);
//        buttonStart_0.addActionListener(this);
//        jpn_2.add(buttonStart_7);
//        buttonStart_0.addActionListener(this);
//        jpn_2.add(buttonStart_8);
//        buttonStart_0.addActionListener(this);
//        jpn_2.add(buttonStart_9);
//        buttonStart_0.addActionListener(this);
//        jpn_2.add(button_CE);
//        buttonStart_0.addActionListener(this);
//        jpn_2.add(button_Calc);
//        buttonStart_0.addActionListener(this);
//        jpn_2.add(button_Add);
//        buttonStart_0.addActionListener(this);
//        jpn_2.add(button_Sub);
//        buttonStart_0.addActionListener(this);
//        jpn_2.add(button_Mul);
//        buttonStart_0.addActionListener(this);
//        jpn_2.add(button_Div);
//        buttonStart_0.addActionListener(this);
//        this.add(jpn_2);
//        
//        
//        jpn_3.add(label_2);
//        jpn_3.add(text_2);
//        this.add(jpn_3,"South");
//        
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        
//        @Override
//    	public void actionPerformed(ActionEvent e)
//    	{
//    		//액션 리스너 재정의
//    		if (e.getSource().equals(buttonStart_0))
//    		{
//    			text_1.
//    		}
//    		else
//    		{
//    			JOptionPane.showMessageDialog(this, "2번 버튼 눌렀네");
//    		}
//    	}
 
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
