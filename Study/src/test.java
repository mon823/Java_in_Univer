

public class test {
	
	private static void personCh(Person[] prn, int num, String ch) {
		prn[num].name = ch;
	}
	
	private static void personPrt(Person[] prn) {
		for(int i=0;i<prn.length;i++) {
			System.out.println(prn[i].name+" "+prn[i].position+" ");
		}

	}
	private static void printCharArray(char[] c) {
		for(int i=0;i<c.length;i++) {
			System.out.print(c[i]);
		}
		System.out.println();
	}		
	private static void replaceSpace(char[] c) {
		for(int i=0;i<c.length;i++) {
			if(c[i]==' ')c[i] =',';
		}
	}

	public static void main(String[] args) {
		char c[] = {'T','h','i','s',' ','i','s',' ' ,'a',' ','p','e','n','c','i','l','.'};
		printCharArray(c);
		replaceSpace(c);
		printCharArray(c);
		
	}
}
// 접근 지정자에서 public > protected > 디폴트(같은 패키지) > private
// ex) class D extends B(상속관계)
// static 멤버와 no-static 멤버
// static는 클래스당 하나만 생성됨 == 클래스 멤버라고도 부름
// static은 함수가 끝나도 값이 안사라짐 == 전역변수와 비슷함
// 객체 없이 사용 가능