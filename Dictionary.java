package hw4;

public class Dictionary {
	// DATA MEMBER
	public WordNode root;

	// CONSTRUCTOR
	public Dictionary() {
		root = null;
	}

	public void insertWordNode(String str) {
		// CASE ONE: TEMP WORD
		assert str != null: "Precondition: str is not null";
		WordNode temp = new WordNode(str);
//		assert temp.toString() == str: "Postcondition: node temp is equal to string str";
		// CASE TWO: EMPTY TREE, PLACE FIRST ITEM IN ROOT
		if (root == null) {
			root = temp;
		}
		// CASE THREE: USE INSERT() TO INSERT AT THE CORRECT LOCATION
		else {
			insert(root, temp);
		}
	}

	private void insert(WordNode root, WordNode temp) {
		while (true) {
			// ONE: IGNORE DUPES
			if (temp.getInput().compareTo(root.getInput()) == 0) {
				return;
			}
			// TWO: TRAVEL TO THE LEFT
			if (temp.getInput().compareTo(root.getInput()) < 0) {
				if (root.left != null)
					root = root.left;
				else {
					root.left = temp;
					return;// break;
				}
			}
			// THREE: TRAVLE TO THE RIGHT
			if (temp.getInput().compareTo(root.getInput()) > 0) {
				if (root.right != null) {
					root = root.right;
				} else {
					root.right = temp;
					return;// break;
				}
			}
		}
	}
	boolean result = false;
	public boolean spellCheckRecursive(String str, WordNode root) {
		if (root != null) {
			if (str.compareTo(root.getInput()) == 0) {
				result = true;
			}
			//traverse left
			if (str.compareTo(root.getInput()) < 0) { 
				spellCheckRecursive(str, root.left);
			}
			//traverse right
			if (str.compareTo(root.getInput()) > 0) {
				spellCheckRecursive(str, root.right);
			}
		}
		return result;

	}
}
