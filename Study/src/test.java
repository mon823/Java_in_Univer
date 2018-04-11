import java.util.Scanner;


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

