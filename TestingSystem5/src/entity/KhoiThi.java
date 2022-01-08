package entity;

public class KhoiThi {
	private String name;
	private String khoi;

	public KhoiThi(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKhoi() {
		switch (this.name) {
		case "A":
			this.khoi = "Toán, Lý, Hóa";
			break;
		case "B":
			this.khoi = "Toán, Hóa, Sinh";
			break;
		case "C":
			this.khoi = "Văn, Sử, Địa";
			break;
		}
		return this.khoi;
	}
}
