package items;



public class Item {
	private String name;
	@SuppressWarnings("unused")
	private double price;

	public Item(String N){
		this.name = N;
		if(name.equals("stone"+ForTests.a)){
			ForTests.a++;
//			System.out.println("krok");
//			System.out.println(ForTests.a);
//			System.out.println(ForTests.a);	
//			System.out.println(name);			
		}
	}
	
	/*@Override
	public String toString(){
		return name;
	}*/
	//public final static Item testStone = new Item("stone"+ForTests.a);
}
