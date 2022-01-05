package testingsystem;

import java.time.LocalDate;
import java.util.Random;

public class Exercise4Test2 {

	/* Question 1: In ngẫu nhiên ra 1 số nguyên */
	public void question1() {
		Random random = new Random();
		int n = random.nextInt();
		System.out.println("Số ngẫu nhiên: " + n);
	}

	/*
	 * Question 3: Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in
	 * ngẫu nhiên ra tên của 1 bạn
	 */
	public void question3() {
		String[] nameArray = { "A", "B", "D", "E", "F" };
		Random random = new Random();
		int i = random.nextInt(nameArray.length);
		System.out.println("Tên ngẫu nhiên 1 bạn trong lớp: " + nameArray[i]);
	}

	/*
	 * Question 4: Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày
	 * 20-12- 1995
	 */
	public void question4() {
		Random random = new Random();
		int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();

		System.out.println("minday:" + minDay);
		System.out.println("maxday:" + maxDay);

		long randomInt = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDay);
	}

	/* Question 5: Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây */
	public void question5() {
		Random random = new Random();
		int now = (int) LocalDate.now().toEpochDay();
		int randomDate = now - random.nextInt(365);
		LocalDate reusultDate = LocalDate.ofEpochDay(randomDate);
		System.out.println("Ngày ngẫu nhiên là: " + reusultDate);
	}

	/* Question 7:Lấy ngẫu nhiên 1 số có 3 chữ số */
	public void question7() {
		Random random = new Random();
		int z = random.nextInt(999 - 100 + 1) + 100;
		System.out.println(z);
	}
}
