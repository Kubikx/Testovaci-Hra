/**
 * 
 */
package utils;

import tokens.Token;
import tokens.TokenGui;

/**
 * @author NEO
 *
 */
public class CreateToken {
	public CreateToken(){
		Token t1 = new Token();
		TokenGui t = new TokenGui(t1);
		t.setVisible(true);
		t.setBounds(50, 350, 450, 300);
	}
}
