import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main5397 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String s = br.readLine();

			int len = s.length();
			List list = new List();

			for (int i = 0; i < len; i++) {
				char c = s.charAt(i);

				if (c == '<') {
					list.moveCurFront();
				} else if (c == '>') {
					list.moveCurBack();
				} else if (c == '-') {
					list.remove();
				} else {
					list.add(c);
				}
			}
			
			
			ans.append(list.print());
		}

		System.out.println(ans);
	}

	static class List {
		Info head = new Info('\u0000', null, null);
		Info cur = head;
		int size = 0;

		public List() {

		}

		StringBuilder print() {
			StringBuilder sb= new StringBuilder();
			Info tmp = head.next;
			
			for(int i=0;i<size;i++) {
				sb.append(tmp.c);
				tmp=tmp.next;
			}
			sb.append('\n');
			return sb;
		}
		void moveCurFront() {
			if (cur.pre != null) {
				cur = cur.pre;
			}
		}

		void moveCurBack() {
			if (cur.next != null) {
				cur = cur.next;
			}
		}

		// 현위치 추가
		void add(char c) {
			Info tmp = new Info(c, null, null);

			if (cur.next == null) {
				cur.next = tmp;
				tmp.pre = cur;
			} else {
				Info t = cur.next;
				t.pre = tmp;
				tmp.next = t;

				tmp.pre = cur;
				cur.next = tmp;
			}
			cur = cur.next;
			size++;
		}

		// 현위치 삭제
		void remove() {
			if (size != 0 && cur != head) {
				Info tmp = cur.next;
				cur = cur.pre;

				if (tmp == null) {
					cur.next = tmp;
				} else {
					cur.next = tmp;
					tmp.pre = cur;
				}

				size--;

			}
		}

		boolean isEmpty() {
			return size == 0 ? true : false;
		}

		// size
		int size() {
			return size;
		}

	}

	static class Info {
		char c;
		Info next, pre;

		public Info(char c, Info next, Info pre) {
			super();
			this.c = c;
			this.next = next;
			this.pre = pre;
		}

	}
}
