package Party;

public class Node {
	
	private Node parent;
	private Node leftChild;
	private Node rightSibling;
	
	private String name;
	private int rank;
	private int incScore;
	private int excScore;
	private boolean isInvited;
	
	
	public Node(String name, int rank) {
		this.name = name;
		this.rank = rank;
	}
	
	public void setParent(Node parent){
		this.parent = parent;
	}

	public Node getParent() {
		return parent;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightSibling() {
		return rightSibling;
	}

	public void setRightSibling(Node rightSibling) {
		this.rightSibling = rightSibling;
	}

	public String getName() {
		return name;
	}

	public int getRank() {
		return rank;
	}

	public int getIncScore() {
		return incScore;
	}

	public void setIncScore(int incScore) {
		this.incScore = incScore;
	}

	public int getExcScore() {
		return excScore;
	}

	public void setExcScore(int excScore) {
		this.excScore = excScore;
	}

	public boolean isInvited() {
		return isInvited;
	}

	public void setInvited(boolean isInvited) {
		this.isInvited = isInvited;
	}
}
