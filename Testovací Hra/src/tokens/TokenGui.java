package tokens;

import items.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TokenGui extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Token token;
	private JTextField txtName;
	private JScrollPane scrollPanelForList;
	@SuppressWarnings("rawtypes")
	private JList equippedList;
	private JScrollPane scrollPanelForBundles;
	@SuppressWarnings("rawtypes")
	private JList bundleList;




	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TokenGui(Token t) {
		token = t;
		t = token;//*************************************** UMAZAT
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelName = new JLabel("Name");
		labelName.setBounds(5, 5, 46, 14);
		contentPane.add(labelName);
		
		txtName = new JTextField();
		txtName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nameChange();
			}
		});
		txtName.setBounds(5, 20, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		scrollPanelForList = new JScrollPane((Component) null);
		scrollPanelForList.setBounds(5, 50, 86, 130);
		contentPane.add(scrollPanelForList);
		
		equippedList = new JList(token.getEquipped());
		equippedList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				equippedList.setToolTipText(((Item) equippedList.getSelectedValue()).info());
				if(equippedList.getSelectedValue() instanceof Bundle){
					equippedList.setToolTipText(((Bundle) equippedList.getSelectedValue()).info());
					System.out.println(((Bundle) equippedList.getSelectedValue()).info());
					bundleList.setVisible(true);
					bundleList.setModel(((Bundle) equippedList.getSelectedValue()).getStored());
					//System.out.println("pokus");
				}
				else{
					bundleList.setVisible(false);
				}
			}
		});
		scrollPanelForList.setViewportView(equippedList);
		equippedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		equippedList.getToolTipText();
		
		scrollPanelForBundles = new JScrollPane((Component) null);
		scrollPanelForBundles.setBounds(101, 50, 86, 130);
		contentPane.add(scrollPanelForBundles);
				
		bundleList = new JList();
		bundleList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
					//System.out.println(bundleList.getSelectedValue());
			}
		});
		bundleList.setVisible(false);
		scrollPanelForBundles.setViewportView(bundleList);
/*
		bundleList.setToolTipText("pokus");
		bundleList.getToolTipText();
		*/

	}




	/**
	 * 
	 */
	protected void nameChange() {
		String name = txtName.getText();
		this.setTitle(name);
		token.setName(name);
	}
}
