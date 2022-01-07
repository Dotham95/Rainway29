package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtil {
	private static Scanner scanner = new Scanner(System.in);

	// nhận giá trị số nguyên từ bàn phím
	public static int scanInt() {
		int result = 0;
		boolean stop = false;

		while (stop == false) {
			try {
				result = scanner.nextInt();
				scanner.nextLine();
				stop = true;
			} catch (InputMismatchException e) {
				System.out.println("nhap sai");
				System.out.println("Xin moi ban nhap lai");
				scanner.nextLine();
			}
		}
		return result;
	}
	public static float scanFloat() {
		float result = 0;
		boolean stop = false;

		while (stop == false) {
			try {
				result = scanner.nextFloat();
				scanner.nextLine();
				stop = true;
			} catch (InputMismatchException e) {
				System.out.println("nhap sai");
				System.out.println("Xin moi ban nhap lai");
				scanner.nextLine();
			}
		}
		return result;
	}
	public static String scanStr() {
		return scanner.nextLine();
		
	}
}
