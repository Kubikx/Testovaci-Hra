
package items;

import java.io.PrintWriter;

import javax.swing.DefaultListModel;

public class Bundle extends Item{
	private DefaultListModel<Item> stored = new DefaultListModel<Item>();
	public int capacity;//liters
	public double amountFilled=0;
	public int maximumLoad;//Kg
	public double actualLoad=0; 
	


	public Bundle() {
	}
	public Bundle(String N, int C, int W) {
		super(N);
		this.capacity = C;
		this.maximumLoad=W;
	}

	
	@Override
	public String info(){
		StringBuilder s = new StringBuilder(super.info());
		s.append("\ncapacity: ");
		s.append(capacity);
		s.append("\namount filled: ");
		s.append(amountFilled);
		s.append("\nmaximum load: ");
		s.append(maximumLoad);
		s.append("\nactual load: ");
		s.append(actualLoad);
		return s.toString();	
	}
	public Bundle copy(){
		Bundle b = new Bundle(this.name, this.capacity, this.maximumLoad);
		b.capacity=this.capacity;
		b.maximumLoad=this.maximumLoad;
		return b;
	}
	public DefaultListModel<Item> getStored(){
		return stored;
	}
	@Override
	public void save(PrintWriter out) {
		super.save(out);
		out.println("capacity: "+capacity);
		out.println("amountFilled: "+amountFilled);
		out.println("maximumLoad: "+maximumLoad);
		out.println("actualLoad: "+actualLoad);
		out.println("contains: ");
		for(int i=0; stored.size()>i;i++){
			stored.get(i).save(out, "+ ");
		}
	}

	@Override
	public void save(PrintWriter out, String p) {
		super.save(out, p);
		out.println(p+"capacity: "+capacity);
		out.println(p+"amountFilled: "+amountFilled);
		out.println(p+"maximumLoad: "+maximumLoad);
		out.println(p+"actualLoad: "+actualLoad);
		out.println(p+"contains: ");
		for(int i=0; stored.size()>i;i++){
			stored.get(i).save(out, p+"+ ");
		}
	}
	@Override
	public String load(String in) {
		super.load(in);
		capacity = Integer.parseInt(in.substring(in.indexOf("capacity:")+10, in.substring(in.indexOf("capacity:")+10).indexOf("\n")+in.indexOf("capacity:")+10));
		amountFilled = Double.parseDouble(in.substring(in.indexOf("amountFilled:")+14, in.substring(in.indexOf("amountFilled:")+14).indexOf("\n")+in.indexOf("amountFilled:")+14));
		maximumLoad = Integer.parseInt(in.substring(in.indexOf("maximumLoad:")+13, in.substring(in.indexOf("maximumLoad:")+13).indexOf("\n")+in.indexOf("maximumLoad:")+13));
		actualLoad = Double.parseDouble(in.substring(in.indexOf("actualLoad:")+12, in.substring(in.indexOf("actualLoad:")+12).indexOf("\n")+in.indexOf("actualLoad:")+12));
//		System.out.println(in.substring(0, in.indexOf("ID:")));
		in =  in.substring(in.indexOf("contains:")+11);
//		System.out.println(in.substring(0, in.indexOf("ID:")));
		String preFix = in.substring(in.indexOf("Item"), in.indexOf("ID:"));
		while(in.length()>10 && preFix.equals(in.substring(in.indexOf("Item"), in.indexOf("ID:")))){
//			System.out.println(in);
			if(in.indexOf("Bundle")<in.indexOf("Item") && in.indexOf("Bundle")>0){
				stored.addElement(new Bundle());
				in = stored.lastElement().load(in);
			}else{
				stored.addElement(new Item());
				in = stored.lastElement().load(in);
			}
		}
		return in;
//		System.out.println("test point");
//		System.out.println(in);
		
	}
	
	public static Bundle backpack100l = new Bundle("backpack", 100, 50);
}
