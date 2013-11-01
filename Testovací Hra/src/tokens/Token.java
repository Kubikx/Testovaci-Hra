package tokens;

import items.Item;
import javax.swing.DefaultListModel;


public class Token {
	private String name;
	private DefaultListModel<Item> Equipped = new DefaultListModel<Item>();

	
	public Token(){
		new AddStartingItems(this);
	}
	
	public DefaultListModel<Item> getEquipped(){
		return Equipped;		
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
}
