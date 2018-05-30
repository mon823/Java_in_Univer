
public class Main {

	public static void main(String[] args) {
		String s = "My Name is Tom.";
		int cnt =0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == ' ')
				cnt ++;
		}
		System.out.println(cnt);
	}

}
