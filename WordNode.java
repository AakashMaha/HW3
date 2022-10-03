package hw4;

public class WordNode {
	private String input;
	public WordNode left;
	public WordNode right;

	// CONSTRUCTOR
	public WordNode(String str) {
		this.input = str;
		left = null;
		right = null;
	}

	// GETTER
	public String getInput() {
		return input;
	}

}
