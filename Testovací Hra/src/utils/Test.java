package utils;

import items.Item;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;

import tokens.Token;
import tokens.TokenGui;


@SuppressWarnings("unused")
public class Test {
	private static DefaultListModel<Saveable> saveable = new DefaultListModel<Saveable>();
	private static DefaultListModel<Loadable> tokens = new DefaultListModel<Loadable>();
	private static DefaultListModel<Loadable> items = new DefaultListModel<Loadable>();
	private static DefaultListModel<TokenGui> frames = new DefaultListModel<TokenGui>();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					load();
					/*
					Token t1 = new Token(0);
					saveable.addElement(t1);
					Token t2 = new Token(0);
					saveable.addElement(t2);
					Token t3 = new Token();
					saveable.addElement(t3);    
					BufferedReader br = new BufferedReader(new FileReader("save.txt"));
				    try {
				        StringBuilder sb = new StringBuilder();
				        String line = br.readLine();

				        while (line != null) {
				            sb.append(line);
				            sb.append('\n');
				            line = br.readLine();
				        }
				        String in = sb.toString();
				    } finally {
				        br.close();
				    }
					TokenGui frame = new TokenGui(t1);
					TokenGui frame2 = new TokenGui(t2);
					TokenGui frame3 = new TokenGui(t3);
					frame3.load();
					frame.setVisible(true);
					frame2.setVisible(true);
					frame3.setVisible(true);
					frame.setBounds(50, 50, 450, 300);
					frame2.setBounds(500, 50, 450, 300);
					frame3.setBounds(50, 350, 450, 300);//*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void save(){
        PrintWriter out = null;
		try {
	        FileWriter filer = new FileWriter("save"+".txt");
	        out = new PrintWriter(filer);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for(int i=0;saveable.getSize()>i;i++){
			saveable.get(i).save(out);
			out.println("*");
		}
    	out.close();
	}
	public static void load() throws IOException{
		BufferedReader br = null;
		br = new BufferedReader(new FileReader("save.txt"));
	    String line = br.readLine();
	    int posx=50,posy=50;
	    while (line != null) {
		    StringBuilder sb = new StringBuilder();
		    int t=0,tc=0;
		    int i=0,ic=0; 
	    	while (!line.endsWith("*")) {
	    		sb.append(line);
	    		sb.append('\n');
	    		//System.out.println(line);
	    		if(line.endsWith("Token")){
	    			//System.out.println("ok");
	    			tokens.add(t,new Token());
	    	    	t++;
	    		}/*else if(line.endsWith("Item")){
	    			//System.out.println("ok");
	    			items.add(i, new Item());
	    			i++;
	    		}*/
	    		line = br.readLine();
	    	}
	    	String in = sb.toString();
//	    	System.out.println("load start___________________________________________________________________________________________________");
	    	if(tc!=t){
				//System.out.println(((Token) tokens.get(tc)).getName());
		    	tokens.get(tc).load(in);
				//System.out.println(((Token) tokens.get(tc)).getName());
				frames.addElement(new TokenGui((Token) tokens.get(tc)));
				//System.out.println(frames.lastElement().getName());
				frames.lastElement().setVisible(true);
				frames.lastElement().setBounds(posx, posy, 450, 300);
				frames.lastElement().load();
				posx+=450;
	    		tc++;
	    	}/*
	    	if(ic!=i){
		    	items.get(ic).load(in);
	    		ic++;
	    	}*/
//	    	System.out.println("load end___________________________________________________________________________________________________");
	    	line = br.readLine();
	    }
    	br.close();
    	//String in = sb.toString();
    	//System.out.println("load complete___________________________________________________________________________________________________");
	}
	
}
