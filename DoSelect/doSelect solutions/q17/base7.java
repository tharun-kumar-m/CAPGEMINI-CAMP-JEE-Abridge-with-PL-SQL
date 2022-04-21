package q17;

import java.util.Scanner;

public class base7 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		StringBuilder sb = new StringBuilder();
        while (n >= 7) {
            sb.append(n % 7);
            n /= 7;
        }
        sb.append(n).reverse();
        System.out.println(sb);
        sc.close();
	}
}
