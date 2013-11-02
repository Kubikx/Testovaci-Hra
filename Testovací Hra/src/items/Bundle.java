
package items;

import java.io.PrintWriter;

import javax.swing.DefaultListModel;

public class Bundle extends Item{
	private DefaultListModel<Item> stored = new DefaultListModel<Item>();
	public int capacity;//liters
	public int amountFilled=0;
	public int maximumLoad;//Kg
	public int actualLoad=0; 
	

	
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
	public static Bundle backpack100l = new Bundle("backpack", 100, 50);
}
