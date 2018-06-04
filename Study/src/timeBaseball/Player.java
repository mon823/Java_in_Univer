package timeBaseball;
// v1.1 2018.5.28 ���� ����: sendRequest()�� showStatistics()�� public���� ����.
// �ڽ� Ŭ�������� startGame()�� ������ �޼ҵ带 ���� �ڵ� ���� (��õ���� ����) 

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
		System.out.println("������ ������... " + serverIP + ":"+ port);
		try {
			socket = new Socket(serverIP, port);
			System.out.println("������ ���� ����");
			out = new PrintWriter( socket.getOutputStream(), true) ;
			in = new Scanner( socket.getInputStream() );
			System.out.println("����� ��� �غ� ��");
		} catch (Exception e) {
			System.err.println("���� ���� ����");
			System.exit(0);
		}
	}

	public void startGame(int repeat) {
		String response = sendRequest("GAME " + repeat);
		System.out.println( response );

		for(int i=0; i<repeat; i++) {
			onInningStart(); // abstract method ����(�̴�) ���ۿ� ���� �ʱ�ȭ
			String result = "";
			while( !result.equals("3s0b") ) {
				String num = pickNumber(); //abstract method ���� ����
				result = sendRequest( num ); // ������ ���ڸ� ������ ����� �ޱ�
				onResultReceived(num, result); //abstract method ����� �ݿ��ϱ�
			}
		}
		System.out.println("��� ������ ���ƽ��ϴ�.");
		showStatistics();
	}
	public void startGameTime(int time) {
		String response = sendRequest("TIME " + time);
		System.out.println( response );

		while(true) {
			onInningStart(); // abstract method
			String result = "";
			while( !result.equals("3s0b") ) {
				String num = pickNumber(); //abstract method ���� ����
				result = sendRequest( num ); // ������ ���ڸ� ������ ����� �ޱ�
				if( result.equals("END") ) {
					System.out.println("���� �ð��� ����Ǿ����ϴ�.");
					showStatistics();
					return;		
				}
				onResultReceived(num, result); //abstract method ����� �ݿ��ϱ�
			}
		}
	}
	public abstract String pickNumber();
	public abstract void onResultReceived(String num, String result);
	public abstract void onInningStart();
	public void showStatistics() {
		String stat = sendRequest( "STAT" ); // ��� ��û
		System.out.println( stat );
	}
	public String sendRequest(String command) {
		String response = null;
		try {
			out.println( command );
			response = in.nextLine();
			
		} catch( Exception e) {
			System.err.println("������ ������ ���������ϴ�. ���α׷��� �����մϴ�");
			System.exit(0);
		} 
		return response;		
	}
}
