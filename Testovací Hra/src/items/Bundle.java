
package items;

import javax.swing.DefaultListModel;

public class Bundle extends Item{
	public DefaultListModel<Item> stored = new DefaultListModel<Item>();
	public int capacity;//liters
	public int amountFilled=0;
	public int weightCapacity;//Kg
	public int actualWeight=0; 
	

	
	public Bundle(String N, int C, int W) {
		super(N);
		this.capacity = C;
		this.weightCapacity=W;
	}

	public final static Bundle backpack100l = new Bundle("backpack", 100, 10);
}
