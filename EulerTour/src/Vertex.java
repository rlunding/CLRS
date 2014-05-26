import java.util.ArrayList;


public class Vertex {
	
	private ArrayList<Edge> edges;
	private String name;
	
	public Vertex(String name){
		this.setName(name);
		setEdges(new ArrayList<Edge>());
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	
	public void addEdge(Edge e){
		edges.add(e);
	}
	
	public void removeEdge(Edge e){
		edges.remove(e);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vertex: " + name + ", ";
	}

	
}
