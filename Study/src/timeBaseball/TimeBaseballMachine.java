package timeBaseball;
// v1.1 2018.5.28 변경사항: checkNumber()에 오류 검사 기능 추가

import java.io.*;
import java.net.*;
import java.util.*;

class BaseballThread extends Thread{
	private static int numOfPlayers;
	public static final int MAX_GAMES = 1000000;
	public static final int DEFAULT_TIME = 5000; //5초
	public static final int DEFAULT_GAME = 1; //1게임

	private Socket socket; // 클라이언트 접속용 소켓
	private PrintWriter out; // 통신 출력 to the client
	private Scanner in; // 통신 입력 from the client

	private String currentUser; // 현재 접속자(클라이언트) 정보, IP와 port
	private boolean timeOver = false; //타이머에 의한 종료 여부를 체크할 변수

	private int r1, r2, r3; // 랜덤 숫자
	private int totalTrials = 0; // 전체 게임의 누적 시도 횟수
	private int countGame = 0; //진행된 게임 수

	private long startTime, endTime; // 겜임 진행 시간 측정을 위한 변수

	public BaseballThread(Socket socket) {
		numOfPlayers++;
		this.socket = socket;
		currentUser = "["+socket.getRemoteSocketAddress().toString().replace("/","")+"] ";
		System.out.println( "접속자: " + currentUser + "\t 총 접속자 수:" + numOfPlayers);
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new Scanner( socket.getInputStream() );
			//			System.out.println("양방향 통신 준비 완료...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// 클라이언트로부터 메시지를 받고 응답하는 과정을 무한 반복
		while(true){
			String str;
			try {
				str = receiveFromClient(); // 명령어 수신

				String command[] = str.split(" ");
				switch(command[0]) {
				case "GAME":
					int repeat = (command.length > 1) ? Integer.parseInt(command[1]) : DEFAULT_GAME;
					sendToClient(repeat + " 게임을 시작하겠습니다");
					startTime = System.currentTimeMillis();
					doGames(repeat);
					endTime = System.currentTimeMillis();
					break;
				case "TIME":
					int time = (command.length > 1) ? Integer.parseInt(command[1]) : DEFAULT_TIME;
					sendToClient("제한 시간("+time+"ms)동안 게임을 진행합니다."); 
					startTimer(time); 
					doGames(MAX_GAMES);
					break;
				case "STAT": 
					sendStatistics(); 
					break;
				default : // 잘못된 명령어 수신시
					// sendToClient("사용법: GAME 횟수 | TIME 시간 | STAT");
					sendToClient("END");
				}	
			} catch (InterruptedException e) {
				System.err.println(currentUser+"클라이언트 연결이 끊어짐");
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
		//System.out.println("/* random 값:" + r1 + r2+ r3 +" */");		
	}
	private String receiveFromClient() throws InterruptedException{
		String msg=null;
		try {
			msg = in.nextLine().trim(); 
		} catch (NoSuchElementException e) {
			// 클라이언트 연결 끊어진 경우
			throw new InterruptedException();
		}
		return msg;
	}
	private void sendToClient(String msg) {
		if( socket == null ) {
			System.err.println("접속된 Client가 없습니다.");
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
			sendToClient(result); // 수에 대한 답을 Client로 전송(?s?b)
		} while( !result.equals("3s0b") );
		// 현재 이닝이 끝날때 까지는 timeout 고려하지 않음

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
		// 타이머 타스크를 만들어 실행
		// 타이머 만료시 실행될 작업 객체를 정의(준비)
		TimerTask task = new TimerTask() {
			public void run() {
				timeOver = true; //게임 종료 조건을 true로 설정
				System.out.println(currentUser+"타이머 만료됨: " + new Date());
				endTime = System.currentTimeMillis();
			}
		};
		// 타이머 객체를 만들고 위에서 준비한 작업을 스케줄러에 넣어서 타이머 시작시킴
		Timer timer = new Timer();
		System.out.println(currentUser + time + "ms 타이머 시작됨: " + new Date());
		startTime = System.currentTimeMillis();
		timer.schedule(task, time); // 여기서부터 실제 타이머 가동
	}
	private void sendStatistics() {
		// 통계 계산
		double avg = (double)totalTrials / countGame ; 
		String stat = "총게임수:"+countGame+", 총시도수:"+totalTrials + ", 평균시도수:" +avg + ", gameTime="+(endTime-startTime)+"ms, 총 접속자 수:" + numOfPlayers;
		System.out.println(currentUser + stat);
		sendToClient(stat);		
	}

	public String checkNumber(String num){
		int n = 0;
		try {
			n = Integer.parseInt(num);
		} catch (NumberFormatException e) {
			return "error"; // 숫자가 아닌 경우 오류
		}
		
		int n1 = n / 100;
		int n2 = n / 10 %10;
		int n3 = n % 10;

		if( n1 == n2 || n1 == n3 || n2 == n3 ) return "error"; // 숫자 중복 오류
		
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
			System.out.println("서버가 시작되었습니다... " + Inet4Address.getLocalHost().getHostAddress() +":"+ PORT);
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.print("\n클라이언트가 접속하였습니다. ");
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
			System.out.println("서버 종료합니다.");			
		}
	}
}
