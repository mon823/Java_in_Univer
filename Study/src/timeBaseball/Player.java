package timeBaseball;
// v1.1 2018.5.28 변경 사항: sendRequest()와 showStatistics()을 public으로 변경.
// 자식 클래스에서 startGame()과 유사한 메소드를 직접 코딩 가능 (추천하지 않음) 

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

abstract class Player {
	private PrintWriter out;
	private Scanner in;
	private Socket socket;

	public Player(String serverIP, int port) {
		connect(serverIP, port);
	}
	private void connect(String serverIP, int port) {
		System.out.println("서버에 연결중... " + serverIP + ":"+ port);
		try {
			socket = new Socket(serverIP, port);
			System.out.println("서버에 접속 성공");
			out = new PrintWriter( socket.getOutputStream(), true) ;
			in = new Scanner( socket.getInputStream() );
			System.out.println("양방향 통신 준비 끝");
		} catch (Exception e) {
			System.err.println("서버 연결 실패");
			System.exit(0);
		}
	}

	public void startGame(int repeat) {
		String response = sendRequest("GAME " + repeat);
		System.out.println( response );

		for(int i=0; i<repeat; i++) {
			onInningStart(); // abstract method 게임(이닝) 시작에 따른 초기화
			String result = "";
			while( !result.equals("3s0b") ) {
				String num = pickNumber(); //abstract method 숫자 고르기
				result = sendRequest( num ); // 서버로 숫자를 보내고 결과를 받기
				onResultReceived(num, result); //abstract method 결과를 반영하기
			}
		}
		System.out.println("모든 게임을 마쳤습니다.");
		showStatistics();
	}
	public void startGameTime(int time) {
		String response = sendRequest("TIME " + time);
		System.out.println( response );

		while(true) {
			onInningStart(); // abstract method
			String result = "";
			while( !result.equals("3s0b") ) {
				String num = pickNumber(); //abstract method 숫자 고르기
				result = sendRequest( num ); // 서버로 숫자를 보내고 결과를 받기
				if( result.equals("END") ) {
					System.out.println("제한 시간이 종료되었습니다.");
					showStatistics();
					return;		
				}
				onResultReceived(num, result); //abstract method 결과를 반영하기
			}
		}
	}
	public abstract String pickNumber();
	public abstract void onResultReceived(String num, String result);
	public abstract void onInningStart();
	public void showStatistics() {
		String stat = sendRequest( "STAT" ); // 통계 요청
		System.out.println( stat );
	}
	public String sendRequest(String command) {
		String response = null;
		try {
			out.println( command );
			response = in.nextLine();
			
		} catch( Exception e) {
			System.err.println("서버와 연결이 끊어졌습니다. 프로그램을 종료합니다");
			System.exit(0);
		} 
		return response;		
	}
}
