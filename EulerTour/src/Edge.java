
public class Edge {
	
	private Vertex start;
	private Vertex end;
	
	public Edge(Vertex start, Vertex end) {
		super();
		this.start = start;
		this.end = end;
	}

	public Vertex getStart() {
		return start;
	}

	public Vertex getEnd() {
		return end;
	}
}
