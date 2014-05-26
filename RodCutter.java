
public class RodCutter {
	
	public RodCutter(){
		//		  1   2  3  4  5   6   7   8   9   10
		int p[] = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};		//Array with prices
		System.out.println(memoizedCutRod(p, 4, 1));
		System.out.println(cutRod(p, 4));
	}
	
	/** Recursive top-down implementation with cost, c, for cutting.
	 */
	private int cutRod(int p[], int n){
		if(n == 0){
			return 0;
		}
		int q = Integer.MIN_VALUE;
		for(int i = 1; i <= n; i++){
			q = Math.max(q, p[i-1] + cutRod(p, n - i));
		}
		return q;
	}
	
	private int memoizedCutRod(int p[], int n, int cutPrice){
		int r[] = new int[n + 1];
		for(int i = 0; i < r.length; i++){
			r[i] = Integer.MIN_VALUE;
		}
		int result = memoizedCutRodAux(p, n, r, cutPrice);
		printArray(r);
		return result;
	}
	
	private int memoizedCutRodAux(int p[], int n, int r[], int cutPrice){
		int q;
		if(r[n] >= 0){
			return r[n];
		}
		if(n == 0){
			q = 0;
		} else {
			q = Integer.MIN_VALUE;
			for(int i = 1; i <= n; i++){
				int max = p[i - 1] + memoizedCutRodAux(p, n  - i, r, cutPrice);
				//if(max == q) System.out.println("i: " + i);
				if(i != n){
					max -= cutPrice;
				}
				q = Math.max(q,  max);
				
			}
		}
		r[n] = q;
		return q;
	}
	
	private void printArray(int input[]){
		for(int i : input){
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new RodCutter();
	}

}
