
public class Goods {
	private String name;
	private int price;
	private int numberOfStock;
	private int sold;
	
	public Goods(String n,int p,int num,int so) {
		name = n;
		price = p;
		numberOfStock = num;
		sold = so;
	}
	public String getName() {
		return name;
	}
	public int getPrcie() {
		return price;
	}
	public int getNumberOfStock() {
		return numberOfStock;
	}
	public int getSold() {
		return sold;
	}
	public void show_goods() {
		System.out.print(name+" ");
		System.out.print(price+" ");
		System.out.print(numberOfStock+" ");
		System.out.println(sold);
	}
	
}


// pubㅣic 안쓰면 디폴트 == 다른곳에서 참조 불가