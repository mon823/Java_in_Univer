package assignment;


import java.awt.Color;
import java.awt.GridLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JPanel; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


class MyFrame extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	
	JButton buttonStart_0 = new JButton("0");
	JButton buttonStart_1 = new JButton("1");
	JButton buttonStart_2 = new JButton("2");
	JButton buttonStart_3 = new JButton("3");
	JButton buttonStart_4 = new JButton("4");
	JButton buttonStart_5 = new JButton("5");
	JButton buttonStart_6 = new JButton("6");
	JButton buttonStart_7 = new JButton("7");
	JButton buttonStart_8 = new JButton("8");
	JButton buttonStart_9 = new JButton("9");
	JButton button_CE = new JButton("CE");
	JButton button_Calc = new JButton("계산");
	JButton button_Add = new JButton("+");
	JButton button_Sub = new JButton("-");
	JButton button_Mul = new JButton("X");
	JButton button_Div = new JButton("/");
	
	
	JLabel label_1 = new JLabel("수식 입력 ");
	JLabel label_2 = new JLabel("계산 결과");
	
	
	JPanel jpn_1 = new JPanel(); 
	JPanel jpn_2 = new JPanel(); 
	JPanel jpn_3 = new JPanel();
	
	final JTextField text_1 = new JTextField(20);
	final JTextField text_2 = new JTextField(20);

	public MyFrame(){
        setSize(400, 400);//프레임 크기 설정
        setTitle("계산기 프레임");//창 제목설정
        jpn_2.setLayout(new GridLayout(4,4,5,5));
        
        button_Add.setBackground(new Color(0,255,255));
        button_Sub.setBackground(new Color(0,255,255));
        button_Mul.setBackground(new Color(0,255,255));
        button_Div.setBackground(new Color(0,255,255));
        
		jpn_1.setBackground(new Color(204,204,204));
		jpn_3.setBackground(new Color(255,255,0));
		jpn_2.setBackground(new Color(255,255,255));
        //setLayout(new FlowLayout());//기본설정BoderLayout 에서 FlowLayout으로 변경
        jpn_1.add(label_1);
        jpn_1.add(text_1);
        this.add(jpn_1,"North");
        
        jpn_2.add(buttonStart_0);
        buttonStart_0.addActionListener(this);
        buttonStart_0.getInsets();
        jpn_2.add(buttonStart_1);
        buttonStart_0.addActionListener(this);
        jpn_2.add(buttonStart_2);
        buttonStart_0.addActionListener(this);
        jpn_2.add(buttonStart_3);
        buttonStart_0.addActionListener(this);
        jpn_2.add(buttonStart_4);
        buttonStart_0.addActionListener(this);
        jpn_2.add(buttonStart_5);
        buttonStart_0.addActionListener(this);
        jpn_2.add(buttonStart_6);
        buttonStart_0.addActionListener(this);
        jpn_2.add(buttonStart_7);
        buttonStart_0.addActionListener(this);
        jpn_2.add(buttonStart_8);
        buttonStart_0.addActionListener(this);
        jpn_2.add(buttonStart_9);
        buttonStart_0.addActionListener(this);
        jpn_2.add(button_CE);
        buttonStart_0.addActionListener(this);
        jpn_2.add(button_Calc);
        buttonStart_0.addActionListener(this);
        jpn_2.add(button_Add);
        buttonStart_0.addActionListener(this);
        jpn_2.add(button_Sub);
        buttonStart_0.addActionListener(this);
        jpn_2.add(button_Mul);
        buttonStart_0.addActionListener(this);
        jpn_2.add(button_Div);
        buttonStart_0.addActionListener(this);
        this.add(jpn_2);
        
        
        jpn_3.add(label_2);
        jpn_3.add(text_2);
        this.add(jpn_3,"South");
        
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
public class MyFrameTest {
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
    }
}
 

