

package utils;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tokens.Team;
import tokens.TestToken;


public class TestGui extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Team> comboBox;
	private DefaultComboBoxModel<Team> comboModel = new DefaultComboBoxModel<Team>(Team.values());
	private JTextField textFieldName;


	public TestGui(final JList<TestToken> tokens) {
		TestToken t = new TestToken(Team.NoTeam, "kubik");
		final DefaultListModel<TestToken> listModel = (DefaultListModel<TestToken>) tokens.getModel();
		listModel.addElement(t);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox<Team>();
		comboBox.addItemListener(new ItemListener() {
			boolean changedOrNo=true;
			public void itemStateChanged(ItemEvent arg0) {
				if(changedOrNo){
					listModel.get(0).setTeam(getComboBox());
					System.out.println(listModel);
					changedOrNo=false;
				}else{
					changedOrNo=true;
				}
			}
		});
		comboBox.setModel(comboModel);
		comboBox.setBounds(10, 11, 113, 20);
		contentPane.add(comboBox);
		
		textFieldName = new JTextField();
		textFieldName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {EventQueue.invokeLater(new Runnable() {
				public void run() {
					listModel.get(0).setName(getName());
					System.out.println(listModel);
					Thread.currentThread().interrupt();
				}
			});
			}
		});
		textFieldName.setBounds(133, 11, 105, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
	}
	
	public Team getComboBox(){
		return (Team) comboModel.getSelectedItem();
	}
	public String getName(){
		return textFieldName.getText();
	}
}
