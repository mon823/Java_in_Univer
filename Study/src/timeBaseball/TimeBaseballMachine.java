package timeBaseball;
// v1.1 2018.5.28 �������: checkNumber()�� ���� �˻� ��� �߰�

import java.io.*;
import java.net.*;
import java.util.*;

class BaseballThread extends Thread{
	private static int numOfPlayers;
	public static final int MAX_GAMES = 1000000;
	public static final int DEFAULT_TIME = 5000; //5��
	public static final int DEFAULT_GAME = 1; //1����

	private Socket socket; // Ŭ���̾�Ʈ ���ӿ� ����
	private PrintWriter out; // ��� ��� to the client
	private Scanner in; // ��� �Է� from the client

	private String currentUser; // ���� ������(Ŭ���̾�Ʈ) ����, IP�� port
	private boolean timeOver = false; //Ÿ�̸ӿ� ���� ���� ���θ� üũ�� ����

	private int r1, r2, r3; // ���� ����
	private int totalTrials = 0; // ��ü ������ ���� �õ� Ƚ��
	private int countGame = 0; //����� ���� ��

	private long startTime, endTime; // ���� ���� �ð� ������ ���� ����

	public BaseballThread(Socket socket) {
		numOfPlayers++;
		this.socket = socket;
		currentUser = "["+socket.getRemoteSocketAddress().toString().replace("/","")+"] ";
		System.out.println( "������: " + currentUser + "\t �� ������ ��:" + numOfPlayers);
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new Scanner( socket.getInputStream() );
			//			System.out.println("����� ��� �غ� �Ϸ�...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// Ŭ���̾�Ʈ�κ��� �޽����� �ް� �����ϴ� ������ ���� �ݺ�
		while(true){
			String str;
			try {
				str = receiveFromClient(); // ��ɾ� ����

				String command[] = str.split(" ");
				switch(command[0]) {
				case "GAME":
					int repeat = (command.length > 1) ? Integer.parseInt(command[1]) : DEFAULT_GAME;
					sendToClient(repeat + " ������ �����ϰڽ��ϴ�");
					startTime = System.currentTimeMillis();
					doGames(repeat);
					endTime = System.currentTimeMillis();
					break;
				case "TIME":
					int time = (command.length > 1) ? Integer.parseInt(command[1]) : DEFAULT_TIME;
					sendToClient("���� �ð�("+time+"ms)���� ������ �����մϴ�."); 
					startTimer(time); 
					doGames(MAX_GAMES);
					break;
				case "STAT": 
					sendStatistics(); 
					break;
				default : // �߸��� ��ɾ� ���Ž�
					// sendToClient("����: GAME Ƚ�� | TIME �ð� | STAT");
					sendToClient("END");
				}	
			} catch (InterruptedException e) {
				System.err.println(currentUser+"Ŭ���̾�Ʈ ������ ������");
				numOfPlayers--;
				return;			
			} 
		}		
	}
	private void generateNumber() {
		do {
			r1 = (int)(Math.random()*10);
			r2 = (int)(Math.random()*10);
			r3 = (int)(Math.random()*10);			
		} while (r1==r2 || r1==r3 || r2==r3);
		//System.out.println("/* random ��:" + r1 + r2+ r3 +" */");		
	}
	private String receiveFromClient() throws InterruptedException{
		String msg=null;
		try {
			msg = in.nextLine().trim(); 
		} catch (NoSuchElementException e) {
			// Ŭ���̾�Ʈ ���� ������ ���
			throw new InterruptedException();
		}
		return msg;
	}
	private void sendToClient(String msg) {
		if( socket == null ) {
			System.err.println("���ӵ� Client�� �����ϴ�.");
			System.exit(0);
		}
		out.println(msg);
	}
	
	private int doOneInningGame() throws InterruptedException {
		generateNumber();
		int trials = 0;
		String result ="";
		do {
			String num = receiveFromClient();
			trials++;
			result = checkNumber( num );
			sendToClient(result); // ���� ���� ���� Client�� ����(?s?b)
		} while( !result.equals("3s0b") );
		// ���� �̴��� ������ ������ timeout ������� ����

		return trials;
	}
	private void doGames(int repeat) throws InterruptedException {
		timeOver = false;
		totalTrials = 0;
		countGame=0;
		while( countGame<repeat ) {
			int trials = doOneInningGame();
			totalTrials += trials;
			countGame++;
			if( timeOver ) return;
		}
	}
	private void startTimer(int time) {
		// Ÿ�̸� Ÿ��ũ�� ����� ����
		// Ÿ�̸� ����� ����� �۾� ��ü�� ����(�غ�)
		TimerTask task = new TimerTask() {
			public void run() {
				timeOver = true; //���� ���� ������ true�� ����
				System.out.println(currentUser+"Ÿ�̸� �����: " + new Date());
				endTime = System.currentTimeMillis();
			}
		};
		// Ÿ�̸� ��ü�� ����� ������ �غ��� �۾��� �����ٷ��� �־ Ÿ�̸� ���۽�Ŵ
		Timer timer = new Timer();
		System.out.println(currentUser + time + "ms Ÿ�̸� ���۵�: " + new Date());
		startTime = System.currentTimeMillis();
		timer.schedule(task, time); // ���⼭���� ���� Ÿ�̸� ����
	}
	private void sendStatistics() {
		// ��� ���
		double avg = (double)totalTrials / countGame ; 
		String stat = "�Ѱ��Ӽ�:"+countGame+", �ѽõ���:"+totalTrials + ", ��սõ���:" +avg + ", gameTime="+(endTime-startTime)+"ms, �� ������ ��:" + numOfPlayers;
		System.out.println(currentUser + stat);
		sendToClient(stat);		
	}

	public String checkNumber(String num){
		int n = 0;
		try {
			n = Integer.parseInt(num);
		} catch (NumberFormatException e) {
			return "error"; // ���ڰ� �ƴ� ��� ����
		}
		
		int n1 = n / 100;
		int n2 = n / 10 %10;
		int n3 = n % 10;

		if( n1 == n2 || n1 == n3 || n2 == n3 ) return "error"; // ���� �ߺ� ����
		
		int strikeCount = 0; 
		int ballCount = 0;

		if(n1==r1) strikeCount++;
		if(n2==r2) strikeCount++;
		if(n3==r3) strikeCount++;
		if(n1==r2 || n1==r3) ballCount++;
		if(n2==r1 || n2==r3) ballCount++;
		if(n3==r1 || n3==r2) ballCount++;

		return strikeCount+"s" + ballCount +"b";
	}
}
public class TimeBaseballMachine {
	private static final int PORT = 8000; 

	public static void main(String[] args) {
		new TimeBaseballMachine().start();
	}

	public void start() {
		ServerSocket serverSocket=null;
		try{
			serverSocket = new ServerSocket(PORT);
			System.out.println("������ ���۵Ǿ����ϴ�... " + Inet4Address.getLocalHost().getHostAddress() +":"+ PORT);
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.print("\nŬ���̾�Ʈ�� �����Ͽ����ϴ�. ");
				new BaseballThread(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("���� �����մϴ�.");			
		}
	}
}
