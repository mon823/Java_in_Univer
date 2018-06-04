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
	public String pickNumber() { // 숫자 고르기
		return String.valueOf(guessNum++);
	}

	@Override
	public void onResultReceived(String num, String result) {
		// 결과에 따라 어떻게 선택할지? 예) 어떤 숫자는 선택하지 않도록 지정
		if( result.equals("3s0b") ) 
			System.out.println("정답!!!");		
	}
	@Override
	public void onInningStart() {
		// 최초에 초기화 할 코드
		guessNum = 0;		
	}

}
