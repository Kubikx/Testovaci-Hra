package items;

import java.io.PrintWriter;

import utils.IDList;
import utils.Loadable;
import utils.Saveable;



public class Item implements Saveable, Loadable {
    protected int ID;
    protected String name;
    protected double price;
    protected double weight;

    public Item(String N){
	this.name = N;
	this.ID=IDList.ItemID;
	IDList.ItemID++;
    }
    public Item(){
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

	@Override
	public void save(PrintWriter out) {
		out.println("Item");
		out.println("ID: "+ID);
		out.println("name: "+name);
		out.println("price: "+price);
		out.println("weight: "+weight);
	}


	@Override
	public void save(PrintWriter out, String p) {
		out.println(p+"Item");
		out.println(p+"ID: "+ID);
		out.println(p+"name: "+name);
		out.println(p+"price: "+price);
		out.println(p+"weight: "+weight);
	}


	@Override
	public void load(String in) {
		// TODO Auto-generated method stub
		
	}

}
