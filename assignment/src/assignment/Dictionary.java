package assignment;

public class Dictionary {
	private static String[] kro = {"»ç¶û","¾Æ±â","µ·","¹Ì·¡","Èñ¸Á"};
	private static String[] eng = {"love","baby","money","future","hope"};
	public static void kor2Eng (String word) {
		for(int i=0;i<kro.length;i++) {
			if(word.equals(kro[i])) {
				System.out.println(word+"Àº "+eng[i]);
			}
			else {
				System.out.println("¾ø´Â´Ü¾î");
			}
		}
	}
}
