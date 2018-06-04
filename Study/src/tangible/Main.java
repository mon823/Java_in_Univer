package tangible;

import java.util.ArrayList;

public class Main {
	private int T;
	private int N;
	private int M;
	private int K;
	private int[] deg = new int[DefineConstants.MAXN];
	private boolean[] V = new boolean[DefineConstants.MAXN];
	private ArrayList<Integer>[] con = tangible.Arrays.initializeWithDefaultClassicVectorInstances(DefineConstants.MAXN);
	private int[] a = new int[10000];

	private void del(int n)
	{
		if (V[n])
		{
			return;
		}
		V[n] = true;
		for (int t : con[n])
		{
			if (!V[t] && --deg[t] < K)
			{
				del(t);
			}
		}
	}

	private static int Main()
	{
		int i;
		int j;
		int k;
		for ((T; T--; = ConsoleInput.readToWhiteSpace(true)).length() > 0)
		{
			N = Integer.parseInt(ConsoleInput.readToWhiteSpace(true));
			K = Integer.parseInt(ConsoleInput.readToWhiteSpace(true));
			M = Integer.parseInt(ConsoleInput.readToWhiteSpace(true));
			for (i = 1; i <= N; i++)
			{
				deg[i] = V[i] = false;
			}
			for (i = 1; i <= M; i++)
			{
				j = Integer.parseInt(ConsoleInput.readToWhiteSpace(true));
				k = Integer.parseInt(ConsoleInput.readToWhiteSpace(true));
				deg[j]++;
				deg[k]++;
				con[j].add(k);
				con[k].add(j);
			}
			for (i = 1; i <= N; i++)
			{
				if (deg[i] < K)
				{
					del(i);
				}
			}
			int ans = 0;
			for (i = 1; i <= N; i++)
			{
				if (!V[i])
				{
					ans++;
				}
			}
			System.out.printf("%d\n", ans);
		}
	}


	final class DefineConstants
	{
		public static final int MAXN = 2001;
	}

