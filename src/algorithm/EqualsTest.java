package algorithm;

import java.util.HashSet;

import org.junit.Test;

public class EqualsTest {

	class Point{
		private int x;
		private int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			if(!(o instanceof Point)) {
				return false;
			}
			Point point = (Point)o;
			return this.x==point.x && this.y==point.y;
		}
		
		@Override
		public int hashCode() {
			int result = 17;
			result = 31*result + this.x;
			result = 31*result + this.y;
			return result;
		}
	}

	@Test
	public void testEquals() {
		Point p1 = new Point(2, 3);
		Point p2 = new Point(2, 3);
		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
	}

	@Test
	public void testHash() {
		Point p1 = new Point(2, 3);
		Point p2 = new Point(2, 3);
		HashSet<Point> set = new HashSet<>();
		set.add(p1);
		set.add(p2);
		System.out.println(set.size());
	}
}
