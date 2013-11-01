package items;

import utils.IDList;



public class Item {
    private int ID;
    protected String name;
    protected double price;
    protected double weight;

    public Item(String N){
	this.name = N;
	this.ID=IDList.ItemID;
	IDList.ItemID++;
    }
    
    
    public int getID(){
	return ID;
    }
	public Item copy(){
		Item i = new Item(name);
		i.price = this.price;
		i.weight = this.weight;
		return i;
	}
	public String info(){
		StringBuilder s = new StringBuilder("\nID: ");
		s.append(ID);
		s.append("\nname: ");
		s.append(name);
		s.append("\nprice: ");
		s.append(price);
		s.append("\nweight: ");
		s.append(weight);
		return s.toString();	
	}
    @Override
    public String toString(){
	return /*ID+" "+*/name;
    }
	public static Item stone = new Item("stone");
}
