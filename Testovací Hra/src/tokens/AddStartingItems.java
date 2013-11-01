
package tokens;

import items.*;

public class AddStartingItems {
	public AddStartingItems(Token token){
		token.getEquipped().addElement(Bundle.backpack100l.copy());
		((Bundle) token.getEquipped().get(0)).getStored().addElement(Item.stone.copy());
		token.getEquipped().addElement(Item.stone.copy());
	}
}
