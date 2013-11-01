package utils;

import java.awt.EventQueue;

import tokens.Token;
import tokens.TokenGui;


public class Test {


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Token t1 = new Token();
					Token t2 = new Token();
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
