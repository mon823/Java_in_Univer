package timeBaseball;

public class MyPlayer extends Player{

	int guessNum;
	
	public MyPlayer(String serverIP, int port) {
		super(serverIP, port);		
	}

	public static void main(String[] args) {
		MyPlayer p = new MyPlayer("127.0.0.1", 8000);
		p.startGame(10);
		p.startGameTime(1000);
	}

	@Override
	public String pickNumber() { // ���� ����
		return String.valueOf(guessNum++);
	}

	@Override
	public void onResultReceived(String num, String result) {
		// ����� ���� ��� ��������? ��) � ���ڴ� �������� �ʵ��� ����
		if( result.equals("3s0b") ) 
			System.out.println("����!!!");		
	}
	@Override
	public void onInningStart() {
		// ���ʿ� �ʱ�ȭ �� �ڵ�
		guessNum = 0;		
	}

}
