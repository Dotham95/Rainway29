package entity;

public class Waiter extends User {

	public Waiter(String name, double salaryRatio) {
		super(name, salaryRatio);
	}

	@Override
	public Double calculatePay() {
		return salaryRatio * 220;
	}
}
