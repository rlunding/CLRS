import java.util.ArrayList;


public class LCS {
	
	public LCS(){
		int x[] = {1, 0, 0, 1, 0, 1, 0, 1};
		int y[] = {0, 1, 0, 1, 1, 0, 1, 1, 0};
		
		LCSLength(x, y);
		System.out.println(initialMemoizedLCS(x, y));
	}
	
	private int initialMemoizedLCS(int x[], int y[]){
		int m = x.length;
		int n = y.length;
		int c[][] = new int[m+1][n+1];
		for(int i = 0; i < c.length; i++){
			for(int j = 0; j < c[0].length; j++){
				c[i][j] = Integer.MAX_VALUE;
			}
		}
		return memoizedLCS(x, y, m, n, c);
		
	}
	
	//Opgave 15.4-3
	private int memoizedLCS(int x[], int y[], int i, int j, int c[][]){
		if(c[i][j] == Integer.MAX_VALUE){
			if(i == 0 || j == 0) c[i][j] = 0;
			else if (x[i-1] == y[j-1]){
				c[i][j] = memoizedLCS(x, y, i - 1, j - 1, c) + 1;
			} else {
				c[i][j] = Math.max(memoizedLCS(x, y, i, j - 1, c),
						memoizedLCS(x, y, i - 1, j, c));
			}
		}
		return c[i][j];
	}
	
	//Fra bogen
	private void LCSLength(int x[], int y[]){
		int m = x.length;
		int n = y.length;
		String b[][] = new String[m][n];
		int c[][] = new int[m+1][n+1];
		
		for(int i = 1; i <= m; i++){
			c[i][0] = 0;
		}
		for(int j = 0; j <= n; j++){
			c[0][j] = 0;
		}
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				if(x[i] == y[j]){
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = "\u2196"; 
				} else if(c[i - 1][j] >= c[i][j - 1]){
					c[i][j] = c[i - 1][j];
					b[i][j] = "\u2191"; 
				} else {
					c[i][j] = c[i][j - 1];
					b[i][j] = "\u2190"; 
				}
			}
		}
		//System.out.print("\u2329 ");printLCS(b, x, m - 1, n - 1);System.out.println("\u232A");
		System.out.print("\u2329 ");printLCS(x, y, c, m - 1, n - 1);System.out.println("\u232A");
		System.out.println(co);
		printTable(b, c);
	}
	
	
	//Fra bogen
	private void printLCS(String b[][], int x[], int i, int j){
		if(i == 0 || j == 0){
			return;
		}
		if(b[i][j].equals("\u2196")){
			printLCS(b, x, i - 1, j - 1);
			System.out.print(x[i] + " ");
			co.add(new Coordinate(i, j));
		} else if(b[i][j].equals("\u2191")){
			co.add(new Coordinate(i, j));
			printLCS(b, x, i - 1, j);
		} else {
			co.add(new Coordinate(i, j));
			printLCS(b, x, i, j-1);
		}
	}
	
	//Fra opgave 15.4-2
	private void printLCS(int x[], int y[], int c[][], int i, int j){
		if(i < 0 || j < 0){
			return;
		}
		if(x[i] == y[j]){
			printLCS(x, y, c, i - 1, j - 1);
			System.out.print(x[i] + " ");
			co.add(new Coordinate(i, j));
		} else if(c[i - 1][j] >= c[i][j - 1]){
			co.add(new Coordinate(i, j));
			printLCS(x, y, c, i - 1, j);
		} else {
			co.add(new Coordinate(i, j));
			printLCS(x, y, c, i, j - 1);
		}
	}
	
	
	//Bare en liste der skal bruges når der skal skrives ud i konsolen.
	private ArrayList<Coordinate> co = new ArrayList<Coordinate>();
		
	/** Print the a table in the console. Similar to that on page 395, figure 15.8.
	 */
	private void printTable(String b[][], int c[][]){
		System.out.println(" ");		
		for(int i = 0; i < b.length; i++){
			for(int j = 0; j < b[0].length; j++){
				if(b[i][j] != null){
					if(match(i, j)){
						System.out.print(b[i][j] + "*");
					} else {
						System.out.print(b[i][j]);
					}
				}
				System.out.print("\t");
			}
			System.out.println(" ");
			for(int j = 0; j < b[0].length; j++){
				System.out.print(c[i][j] + "\t");
			}
			System.out.println(" ");
			System.out.println(" ");
		}
	}
	
	/** Check the coordinate x, y is in the arraylist co.
	 */
	private boolean match(int x, int y){
		for(int i = 0; i < co.size(); i++){
			if(co.get(i).getX() == x && co.get(i).getY() == y){
				co.remove(i);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		new LCS();
	}
	
	private class Coordinate {
		private int x;
		private int y;
		
		public Coordinate(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
		
	}

}
