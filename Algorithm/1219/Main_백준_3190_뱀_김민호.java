import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_3190_뱀_김민호 {

	public static class Snake {
		int bodynum;
		int x;
		int y;
		char see;

		public Snake(int bodynum, int x, int y, char see) {
			this.bodynum = bodynum;
			this.x = x;
			this.y = y;
			this.see = see;
		}
	}

	public static class Move {
		int time;
		char where;

		public Move(int time, char where) {
			this.time = time;
			this.where = where;
		}

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_뱀.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int apcnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < apcnt; i++) {
			String[] s = br.readLine().split(" ");
			map[Integer.parseInt(s[0]) - 1][Integer.parseInt(s[1]) - 1] = -1;
		}
//  System.out.println(Arrays.deepToString(map));

		int movecnt = Integer.parseInt(br.readLine());
		Move[] movelist = new Move[movecnt];
		for (int i = 0; i < movecnt; i++) {
			String s[] = br.readLine().split(" ");
			int t = Integer.parseInt(s[0]);
			char wh = s[1].charAt(0);
			movelist[i] = new Move(t, wh);
		}
		ArrayList<Snake> list = new ArrayList<>();
		list.add(new Snake(0, 0, 0, 'R'));
		int sec = 0;
		arr = new int[N][N];
		System.out.println(go(list, movelist, sec)+1);
	}

	public static int N, map[][];
	public static boolean alive = true;

	private static int go(ArrayList<Snake> list, Move[] movelist, int sec) {
		for (Move m : movelist) {
			while (sec < m.time) {

				int size = list.size();
				for (int z = 0; z < size; z++) {
					Snake s = list.get(z);
					if (s.see == 'R') {
						if (s.y + 1 < N && map[s.x][s.y + 1] == -1) {// 사과먹음
							list.add(new Snake(list.size() + 1, list.get(list.size() - 1).x,list.get(list.size() - 1).y, 'R'));
							map[s.x][s.y + 1] = 0;
							// continue;
						}
						s.y++;
					} else if (s.see == 'L') {
						if (s.y - 1 >= 0 && map[s.x][s.y - 1] == -1) {
							list.add(new Snake(list.size() + 1, list.get(list.size() - 1).x,list.get(list.size() - 1).y, 'L'));
							map[s.x][s.y - 1] = 0;
							// continue;
						}
						s.y--;
					} else if (s.see == 'D') {
						if (s.x + 1 < N && map[s.x + 1][s.y] == -1) {// 사과먹음
							list.add(new Snake(list.size() + 1, list.get(list.size() - 1).x,list.get(list.size() - 1).y, 'D'));
							map[s.x + 1][s.y] = 0;
							// continue;
						}
						s.x++;
					} else if (s.see == 'U') {
						if (s.x - 1 >= 0 && map[s.x - 1][s.y] == -1) {// 사과먹음
							list.add(new Snake(list.size() + 1, list.get(list.size() - 1).x,list.get(list.size() - 1).y, 'U'));
							map[s.x - 1][s.y] = 0;
							// continue;
						}
						s.x--;
					}
					if(z==0) {
						if(check(list)) {
							alive=false;
							return sec;
						}
					}
					
				}
				if ((list.get(0).x < 0 || list.get(0).x >= N) || (list.get(0).y < 0 || list.get(0).y >= N)) {
					alive = false;
					return sec;
				}
				if (check(list)) { // 내몸이랑 부딫혔는지 확인
					alive = false;
					return sec;
				}
				checksee(list);
				sec++;
			}
			// else if(m.time==sec) { //방향 전환

			if (list.get(0).see == 'R') {
				if (m.where == 'D')
					list.get(0).see = 'D';
				else
					list.get(0).see = 'U';
			} else if (list.get(0).see == 'U') {
				if (m.where == 'D')
					list.get(0).see = 'R';
				else
					list.get(0).see = 'L';
			} else if (list.get(0).see == 'D') {
				if (m.where == 'D')
					list.get(0).see = 'L';
				else
					list.get(0).see = 'R';
			} else if (list.get(0).see == 'L') {
				if (m.where == 'D')
					list.get(0).see = 'U';
				else
					list.get(0).see = 'D';
			}
//   }
		}

		while (alive) {

			int size = list.size();
			for (int z = 0; z < size; z++) {
				Snake s = list.get(z);
				if (s.see == 'R') {
					if (s.y + 1 < N && map[s.x][s.y + 1] == -1) {// 사과먹음
						list.add(new Snake(list.size() + 1, list.get(list.size() - 1).x, list.get(list.size() - 1).y,'R'));
						map[s.x][s.y + 1] = 0;
						// continue;
					}
					s.y++;
				} else if (s.see == 'L') {
					if (s.y - 1 >= 0 && map[s.x][s.y - 1] == -1) {
						list.add(new Snake(list.size() + 1, list.get(list.size() - 1).x, list.get(list.size() - 1).y,'L'));
						map[s.x][s.y - 1] = 0;
						// continue;
					}
					s.y--;
				} else if (s.see == 'D') {
					if (s.x + 1 < N && map[s.x + 1][s.y] == -1) {// 사과먹음
						list.add(new Snake(list.size() + 1, list.get(list.size() - 1).x, list.get(list.size() - 1).y,'D'));
						map[s.x + 1][s.y] = 0;
						// continue;
					}
					s.x++;
				} else if (s.see == 'U') {
					if (s.x - 1 >= 0 && map[s.x - 1][s.y] == -1) {// 사과먹음
						list.add(new Snake(list.size() + 1, list.get(list.size() - 1).x, list.get(list.size() - 1).y,'U'));
						map[s.x - 1][s.y] = 0;
						// continue;
					}
					s.x--;
				}
				if(z==0) {
					if(check(list)) {
						alive=false;
						return sec;
					}
				}
				
			}
			if ((list.get(0).x < 0 || list.get(0).x >= N) || (list.get(0).y < 0 || list.get(0).y >= N)) {
				alive = false;
				return sec;
			}
			if (check(list)) { // 내몸이랑 부딫혔는지 확인
				alive = false;
				return sec;
			}
			checksee(list);
			sec++;
		}
		return sec;
	}

	public static int[][] arr;

	private static void checksee(ArrayList<Snake> list) {
		if (list.size() > 1) {
			for (int z = list.size() - 1; z >= 1; z--) {
				char cursee = list.get(z).see;
				char frontsee = list.get(z - 1).see;
				if (cursee != frontsee) {
					list.get(z).see = frontsee;
				}
			}
		}
	}

	private static boolean check(ArrayList<Snake> list) {
		int headx = list.get(0).x;
		int heady = list.get(0).y;
		for (int z = 1; z < list.size(); z++) {
			if (headx == list.get(z).x && heady == list.get(z).y)
				return true;
		}
		return false;
	}

}