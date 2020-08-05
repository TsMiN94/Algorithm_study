package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Union -find 말고도 BFS로 탐색하여 풀이가능
public class JungOl1863 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<Integer> graph[];
	static boolean[] visited;
	static int n;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		graph = new List[n + 1];
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			graph[f].add(t);
			graph[t].add(f);

		}
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				bfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(i);
		visited[i] = true;

		while (!q.isEmpty()) {
			int v = q.poll();
			List<Integer> childs = graph[v];
			for (int c = 0; c < childs.size(); c++) {
				if (!visited[childs.get(c)]) {
					visited[childs.get(c)] = true;
					q.add(childs.get(c));
				}
			}
		}
	}

	static int pArr[];

	private static void makeSet() {
		pArr = new int[n + 1];
		for (int i = 1; i <= n; i++)
			pArr[i] = i;
	}

	private static int findSet(int a) {
		if (pArr[a] == a)
			return a;
		else {
			return pArr[a] = findSet(a);
		}
	}

	private static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);

		if (a != b) {
			pArr[b] = a;
		}
	}
}
