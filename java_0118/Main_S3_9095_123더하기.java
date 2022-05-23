package java_0118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_9095_123¥ı«œ±‚ {

	public static int T, n;
	public static int[] d = new int[11];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=  new StringBuilder();
		
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		for(int i=4;i<11;i++) {
			d[i] = d[i-1]+d[i-2]+d[i-3];
		}
		
		T = Integer.parseInt(in.readLine());
		for(int i=0;i<T;i++	 ) {
			n = Integer.parseInt(in.readLine());
			sb.append(d[n]).append("\n");
		}
		
		System.out.println(sb);
	}

}
