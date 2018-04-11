
public class Person {
	//private String personId;
	String name;
	String position;
	//String number;
	int age;
	//int weight;
	
	public Person() {
		this("XX","XX");
	}
	
	public Person(String name) {
		this(name,"정보없음");		//this 에서 다른 생성자를 부를떈 먼저 부르기
		this.name = name;
	}
	
	public Person(String name, String position) {
		this.name = name;
		this.position = position;
	} 

	public void show() {
		System.out.println(name+" "+position+" "+age);
	}
	
	
	public void personPrt(Person prn[]) {
		for(int i=0;i<prn.length;i++) {
			System.out.println(prn[i].name+" "+prn[i].position+" ");
		}
	}


//	public void obligation() {
//		System.out.println("공부");
//	}
//	
//	public String get_per_id() {
//		return personId;
//	}
//	public void set_per_id(String person_id) {
//		personId=person_id;
//	}
		
}