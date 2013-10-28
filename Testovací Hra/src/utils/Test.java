

package utils;

import java.awt.EventQueue;





import javax.swing.DefaultListModel;
import javax.swing.JList;

import tokens.*;



public class Test {

	static DefaultListModel<TestToken> listModel = new DefaultListModel<TestToken>();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static JList tokens = new JList(listModel);
	
	public static void main(String[] args) {

		TestToken t = new TestToken(Team.Hr·Ë1, "kubik");
		listModel.addElement(t);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unchecked")/**            */
					TestGui frame = new TestGui(tokens);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		/*
	    List<Team> list = Arrays.asList(Team.values());
	    System.out.println(list);

		System.out.println(new TestToken(Team.Hr·Ë1, "Kubik"));
	    */
		

	}

}
