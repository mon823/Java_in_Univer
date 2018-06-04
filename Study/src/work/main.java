package work;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	class del{
	
		del(int n){
			if(V[n]) return ;
			V[n] = 1;
			for(int t: con[n]) {
				if(!V[t] && --deg[t] <k) del(t);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int T, N, M, K;
		int deg[]= new int[2001];
		boolean V[]= new boolean [2001];
		ArrayList<Integer>  con = new ArrayList<Integer>();
		
		int i,j,k;
		T = scanner.nextInt();
		for(;T==0;T--) {
			N=scanner.nextInt();
			K=scanner.nextInt();
			M=scanner.nextInt();
			for( i=1;i<=N;i++) {
				deg[i]= 0;
				V[i]=false;
			}
			for(i=1;i<=M;i++) {
				j = scanner.nextInt();
				k = scanner.nextInt();
				deg[j] ++;
				deg[k] ++;
				con[j].add(k);
				con[k].add(j);
			}
			for(i=1;i<=N;i++)
				if(deg[i] < K)
					new del(i);
			int ans = 0;
			
			for(i=1;i<=N;i++)
				if(!V[i])ans ++;
			System.out.println(ans);
			
			
		}
		
		
	}

}
