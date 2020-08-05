package com.programmers.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KakaoCave {

	public static void main(String[] args) {
		//int[][] path = { { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } };
		//int[][] order = { { 8, 5 }, { 6, 7 }, { 4, 1 } };

		int[][] path = { { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } };
		int[][] order = { { 4, 1 }, { 8, 7 }, { 6, 5 } };

		System.out.println(Solution.solution(9, path, order));
	}

	static class Solution {
		static List<Integer> graph[];
		static boolean orderVisited[];
		static Queue<Integer> q = new LinkedList<Integer>();
		static int N;
		static boolean answer = true;
		static HashMap<Integer, Integer> orderMap;

		public static boolean solution(int n, int[][] path, int[][] order) {

			N = n;

			orderVisited = new boolean[n];

			graph = new List[n];

			orderMap = new HashMap<Integer, Integer>();

			for (int i = 0; i < n; i++)
				graph[i] = new ArrayList<Integer>();

			for (int[] t : path) {
				graph[t[0]].add(t[1]);
				graph[t[1]].add(t[0]);
			}

			for (int[] t : order) {
				orderMap.put(t[1], t[0]);
			}

			bfs(0);
			return answer;
		}

		private static void bfs(int v) {

			orderVisited = new boolean[N];
			Integer preVisitedVertax;
			int cnt = 1, roofCnt = 0, curV, nextV;
			List<Integer> list;

			q.add(v);

			orderVisited[v] = true;

			while (!q.isEmpty()) {
		
				if (q.size() == roofCnt) { //루프카 도는지를 체크
					answer = false;
					return;
				}

				curV = q.poll();
				
				preVisitedVertax = orderMap.get(curV);
				//현재 정점이 이전의 방문순서를 지켜서 지금 방문할수 있는 정점인지 확인
				//즉 순서가 정해진 정점인데 순서를 지키지 않았다면 이전의 방문해야하는 정점을 방문하지 않았다면 다시 큐에삽입
				if (preVisitedVertax != null) {
					if (!orderVisited[preVisitedVertax]) {
						q.add(curV);
						roofCnt++;
						continue;
					}
				}
				
				// 순서가 정해진 정점이 아니면 그냥 현재 정점을 방문
				orderVisited[curV] = true;

				list = graph[curV];
				roofCnt = 0;
				//정점이 갈수있는 모든 정점을 탐색
				for (int i = 0; i < list.size(); i++) {
					nextV = list.get(i);
					if (orderVisited[nextV])
						continue;
					//탐색하는 과정에서 다음 정점을 방문하면서 큐에 넣는데 다음정점이 방문순서를 가진놈이면 방문
					//했는지를 검사하고 방문했다면 큐에 넣고 해당 정점을 방문했다고 체크
					
					preVisitedVertax = orderMap.get(nextV);
					if (preVisitedVertax != null) {
						if (orderVisited[preVisitedVertax]) {
							orderVisited[nextV] = true;
							cnt++;
							q.add(nextV);
						} else {
							q.add(nextV);
							continue;
						}
					} else {
						// 방문순서가 없는 그냥 갈수있는 정점이라면 방문하고 큐에사입
						orderVisited[nextV] = true;
						cnt++;
						q.add(nextV);
					}

				}
				answer= true;
			}
		}

	}

}
