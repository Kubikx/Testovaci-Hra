package tokens;

import items.Item;

import javax.swing.DefaultListModel;

import utils.IDList;


public class Token {
	private int ID;
	private String name;
	private DefaultListModel<Item> Equipped = new DefaultListModel<Item>();

	
	public Token(){
		new AddStartingItems(this);
		this.ID=IDList.TokenID;
		IDList.TokenID++;
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
	public int getID(){
		return ID;
	}
}
