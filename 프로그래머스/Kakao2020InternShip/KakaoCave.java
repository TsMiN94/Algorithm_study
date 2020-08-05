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
		
				if (q.size() == roofCnt) { //����ī �������� üũ
					answer = false;
					return;
				}

				curV = q.poll();
				
				preVisitedVertax = orderMap.get(curV);
				//���� ������ ������ �湮������ ���Ѽ� ���� �湮�Ҽ� �ִ� �������� Ȯ��
				//�� ������ ������ �����ε� ������ ��Ű�� �ʾҴٸ� ������ �湮�ؾ��ϴ� ������ �湮���� �ʾҴٸ� �ٽ� ť������
				if (preVisitedVertax != null) {
					if (!orderVisited[preVisitedVertax]) {
						q.add(curV);
						roofCnt++;
						continue;
					}
				}
				
				// ������ ������ ������ �ƴϸ� �׳� ���� ������ �湮
				orderVisited[curV] = true;

				list = graph[curV];
				roofCnt = 0;
				//������ �����ִ� ��� ������ Ž��
				for (int i = 0; i < list.size(); i++) {
					nextV = list.get(i);
					if (orderVisited[nextV])
						continue;
					//Ž���ϴ� �������� ���� ������ �湮�ϸ鼭 ť�� �ִµ� ���������� �湮������ �������̸� �湮
					//�ߴ����� �˻��ϰ� �湮�ߴٸ� ť�� �ְ� �ش� ������ �湮�ߴٰ� üũ
					
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
						// �湮������ ���� �׳� �����ִ� �����̶�� �湮�ϰ� ť������
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
