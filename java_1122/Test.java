package java_1122;

import java.awt.Point;

public class Test {

	public static void main(String[] args) {
//		System.out.println(new Point(1, 2).equals(new Point(1,2)));
//		Point start = new Point(1,2);
//		System.out.println(roll(start));
////		roll(start);
//		System.out.println("start : " + start);
		
		System.out.println();
	}

	private static Point roll(Point p) {
		Point temp = (Point) p.clone();
		temp.x++;
		temp.y++;
		return temp;
	}

}
