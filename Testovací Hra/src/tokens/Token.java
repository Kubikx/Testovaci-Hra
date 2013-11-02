package tokens;


import java.io.PrintWriter;

import items.Item;

import javax.swing.DefaultListModel;

import utils.IDList;
import utils.Loadable;
import utils.Saveable;


public class Token implements Saveable, Loadable {
	private int ID;
	private String name;
	private DefaultListModel<Item> equipped = new DefaultListModel<Item>();

	
	public Token(int x){
		new AddStartingItems(this);
		this.ID=IDList.TokenID;
		IDList.TokenID++;
	}
	public Token(){
	}
	public Token(String in){
		load(in);
	}
	
	
	
	public DefaultListModel<Item> getEquipped(){
		return equipped;		
	}
	
	public String getName(){
		//System.out.println("getName: "+name);
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getID(){
		return ID;
	}

//	@Override
//	public String toString(){
//		return ID +" "+ name;
//	}


	public void load(String in) {

		//System.out.println(in.substring(in.indexOf("ID:")+4, in.substring(in.indexOf("ID:")+4).indexOf("\n")+in.indexOf("ID:")+4)); 
		ID = Integer.parseInt(in.substring(in.indexOf("ID:")+4, in.substring(in.indexOf("ID:")+4).indexOf("\n")+in.indexOf("ID:")+4));
		//System.out.println("ID: "+ID);
		name = in.substring(in.indexOf("name:")+6, in.substring(in.indexOf("name:")+6).indexOf("\n")+in.indexOf("name:")+6);
		System.out.println(in);
		new AddStartingItems(this);
		//System.out.println(in.substring(in.indexOf("ID:")+4, in.substring(in.indexOf("ID:")+4).indexOf("\n"))); 
		//System.out.println(in.substring(in.indexOf("ID:")+4, in.substring(in.indexOf("ID:")+4).indexOf("name:")-1));
		//System.out.println("XXXXXXX ----------------- ****************** "+ in.substring(in.indexOf("name:")+6)+"XXXXXXX ----------------- ****************** ");
		//System.out.println("XXXXXXX ----------------- "+in.substring(in.indexOf("name:")+6, in.substring(in.indexOf("name:")+6).indexOf("equiped:")-1 ));
		//ID = Integer.parseInt(in.substring(in.indexOf("ID:")+4, in.indexOf("name:")-1 ));
		//name = in.substring(in.indexOf("name:")+6, in.indexOf("equiped:")-1 );
		//equipped.addElement(in.substring(in.indexOf("equiped:")+6, in.indexOf("equiped:")-1 ));
	} 
	@Override
	public void save(PrintWriter out) {
		out.println("Token");
		out.println("ID: "+ID);
		out.println("name: "+name);
		out.println("equiped: ");
		for(int i=0; equipped.size()>i;i++){
			equipped.get(i).save(out, "- ");
		}
	}



	@Override
	public void save(PrintWriter out, String p) {
		out.println(p + "ID: " + ID);
		out.println(p + "name: " + name);
		out.println(p + "equiped: ");
		for(int i=0; equipped.size()>i;i++){
			equipped.get(i).save(out, p+"- ");
		}
	}




}
