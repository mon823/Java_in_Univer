package assignment;

public class Dictionary {
	private static String[] kro = {"���","�Ʊ�","��","�̷�","���"};
	private static String[] eng = {"love","baby","money","future","hope"};
	public static void kor2Eng (String word) {
		for(int i=0;i<kro.length;i++) {
			if(word.equals(kro[i])) {
				System.out.println(word+"�� "+eng[i]);
			}
			else {
				System.out.println("���´ܾ�");
			}
		}
	}
}
