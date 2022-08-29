package java_0719;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main3 {

	public int solution(int[] order) {
		int answer = 0;
		
		Queue<Integer> belt = new LinkedList<>();
		for(int i=1;i<=order.length;i++	)
			belt.offer(i);
		Stack<Integer> temp= new Stack<>();
		
		while(!belt.isEmpty() && !temp.isEmpty()) {
			
		}
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new int[] { 4, 3, 1, 2, 5 });
		System.out.println(new int[] { 5, 4, 3, 2, 1 });
	}

}
