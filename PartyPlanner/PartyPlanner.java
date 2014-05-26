package Party;

import java.util.ArrayList;

public class PartyPlanner {
	
	public PartyPlanner(){
		ArrayList<Node> VicePresidents = new ArrayList<Node>();
		ArrayList<Node> Managers = new ArrayList<Node>();
		ArrayList<Node> Staff1 = new ArrayList<Node>();
		ArrayList<Node> Staff2 = new ArrayList<Node>();
		
		Node CEO = new Node("John", 3);
		
		Node Gert = new Node("Gert", 4);
		Node Hans = new Node("Hans", 2);
		Node Viggo = new Node("Viggo", 1);
		
		Node J퓊gen = new Node("J퓊gen", 2);
		Node 갾e = new Node("갾e", 12);
		Node Birger = new Node("Birger", 3);
		
		Node B퓊ge = new Node("B퓊ge", 1);
		Node Ole = new Node("Ole", 2);
		Node Sven = new Node("Sven", 1);
		
		Node DH = new Node("Dynamit Harry", 1);
		Node Egon = new Node("Egon", 2);
		Node Keld = new Node("Keld", 1);
		Node Benny = new Node("Benny", 1);
		
		VicePresidents.add(Gert);
		VicePresidents.add(Hans);
		VicePresidents.add(Viggo);
		
		Managers.add(J퓊gen);
		Managers.add(갾e);
		Managers.add(Birger);
		
		Staff1.add(B퓊ge);
		Staff1.add(Ole);
		Staff1.add(Sven);
		
		Staff2.add(Benny);
		Staff2.add(Keld);
		Staff2.add(Egon);
		Staff2.add(DH);
		
		createTree(CEO, VicePresidents);
		createTree(Gert, Managers);
		createTree(갾e, Staff1);
		createTree(Birger, Staff2);
		
		planParty(CEO);
		CEO.setInvited(CEO.getIncScore() >= CEO.getExcScore());
		printPartyPlan(CEO);
		
	}
	
	private void planParty(Node node){
		node.setIncScore(node.getRank());
		node.setExcScore(0);
		
		Node child = node.getLeftChild();
		while(child != null){
			planParty(child);
			node.setIncScore(node.getIncScore() + child.getExcScore());
			node.setExcScore(node.getExcScore() + Math.max(child.getIncScore(), child.getExcScore()));
			child = child.getRightSibling();
		}
	}
	
	private void printPartyPlan(Node node){
		System.out.println(node.getName() + " is" + (node.isInvited() ? "" : " not") + " invited");
		
		Node child = node.getLeftChild();
		while(child != null){
			if(child.getParent().isInvited() == true){
				child.setInvited(false);
			} else {
				child.setInvited(child.getIncScore() >= child.getExcScore());
			}
			printPartyPlan(child);
			child = child.getRightSibling();			
		}
	}
	
	private void createTree(Node root, ArrayList<Node> children){
		if(children.size() < 1 || root == null){
			return;
		}
		root.setLeftChild(children.get(0));
		
		for(int i = 0; i < children.size() - 1; i++){
			children.get(i).setRightSibling(children.get(i + 1));
			children.get(i).setParent(root);
		}
		children.get(children.size() - 1).setParent(root);
	}
		
	public static void main(String[] args) {
		new PartyPlanner();
	}
	
	
}
