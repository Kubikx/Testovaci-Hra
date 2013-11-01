package utils;

import items.ForTests;

import java.awt.EventQueue;

import tokens.Token;
import tokens.TokenGui;


public class Test {

	public final ForTests test = new ForTests();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//new CreateToken();
					Token t1 = new Token();
					Token t2 = new Token();
					if(t1.getEquipped().equals(t2.getEquipped()) || t1.getEquipped() == t2.getEquipped()){//////////CHYBA!!!!!!!!!!!!
						System.out.println("Chyba");
					}else{
						System.out.println("WHAT? How it possible?");
					}
					
					TokenGui frame = new TokenGui(t1);
					TokenGui frame2 = new TokenGui(t2);
					frame.setVisible(true);
					frame2.setVisible(true);
					frame.setBounds(50, 50, 450, 300);
					frame2.setBounds(500, 50, 450, 300);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
