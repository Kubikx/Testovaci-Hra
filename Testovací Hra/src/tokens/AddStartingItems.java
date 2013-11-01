
package tokens;

import items.*;

public class AddStartingItems {
	public AddStartingItems(Token token){
		token.getEquipped().clear();
		token.getEquipped().addElement(Bundle.backpack100l);
		//((Bundle) token.Equipped.get(0)).stored.addElement(Item.testStone);
		//((Bundle) token.getEquipped().get(0)).getStored().addElement(new Item("stone"+ForTests.a));
		//((Bundle) token.getEquipped().get(0)).getStored().addElement(new Item("stone"));
		((Bundle) token.getEquipped().get(0)).getStored().addElement(new Item("stone"));
	}
}
