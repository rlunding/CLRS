import java.util.Collections;
import java.util.Stack;


public class EulerTour {
	
	private Stack<Vertex> tour = new Stack<Vertex>();
	
	public EulerTour(){	
		ex1();
		ex2();
		ex3();
		ex4();
	}
	
	private void tour(Vertex v){
		while(!v.getEdges().isEmpty()){
			Edge edge = v.getEdges().iterator().next();
			v.removeEdge(edge);
			tour(edge.getEnd());
		}
		tour.add(v);
	}

	private void ex1(){
		tour = new Stack<Vertex>();
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Edge e12 = new Edge(v1, v2);
		Edge e21 = new Edge(v2, v1);
		Edge e23 = new Edge(v2, v3);
		Edge e34 = new Edge(v3, v4);
		Edge e45 = new Edge(v4, v5);
		Edge e52 = new Edge(v5, v2);
		v1.addEdge(e12);
		v2.addEdge(e21);
		v2.addEdge(e23);
		v3.addEdge(e34);
		v4.addEdge(e45);
		v5.addEdge(e52);
		tour(v1);
		Collections.reverse(tour);
		System.out.println(tour.toString());
	}
	
	private void ex2(){
		tour = new Stack<Vertex>();
		Vertex v1 = new Vertex("1");
		Vertex v15 = new Vertex("1.5");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Edge e12 = new Edge(v1, v2);
		Edge e115 = new Edge(v1, v15);
		Edge e151 = new Edge(v15, v1);
		Edge e152 = new Edge(v15, v2);
		Edge e215 = new Edge(v2, v15);
		Edge e21 = new Edge(v2, v1);
		Edge e23 = new Edge(v2, v3);
		Edge e34 = new Edge(v3, v4);
		Edge e45 = new Edge(v4, v5);
		Edge e52 = new Edge(v5, v2);
		v1.addEdge(e12);
		v1.addEdge(e115);
		v15.addEdge(e151);
		v15.addEdge(e152);
		v2.addEdge(e215);
		v2.addEdge(e21);
		v2.addEdge(e23);
		v3.addEdge(e34);
		v4.addEdge(e45);
		v5.addEdge(e52);
		tour(v1);
		Collections.reverse(tour);
		System.out.println(tour.toString());
	}
	
	private void ex3(){
		tour = new Stack<Vertex>();
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Edge e12 = new Edge(v1, v2);
		Edge e23 = new Edge(v2, v3);
		Edge e31 = new Edge(v3, v1);
		v1.addEdge(e12);
		v2.addEdge(e23);
		v3.addEdge(e31);
		tour(v1);
		Collections.reverse(tour);
		System.out.println(tour.toString());
	}
	
	private void ex4(){
		tour = new Stack<Vertex>();
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Edge e12 = new Edge(v1, v2);
		Edge e23 = new Edge(v2, v3);
		Edge e31 = new Edge(v3, v1);
		Edge e32 = new Edge(v3, v2);
		v1.addEdge(e12);
		v2.addEdge(e23);
		v3.addEdge(e31);
		v3.addEdge(e32);
		tour(v1);
		Collections.reverse(tour);
		System.out.println(tour.toString());
	}
	
	
	public static void main(String[] args) {
		new EulerTour();
	}
}
