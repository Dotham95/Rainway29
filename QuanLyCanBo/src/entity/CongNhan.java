package entity;

public class CongNhan extends CanBo {

	private int bac;

	public CongNhan() {
		super();
	}

	public CongNhan(String hoTen, int tuoi, int bac) {
		super(hoTen, tuoi);
		this.bac = bac;
	}

	public CongNhan(String hoTen, int tuoi, gioiTinh gioiTinh, String diaChi, int bac) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.bac = bac;
	}

	public int getBac() {
		return bac;
	}

	public void setBac(int bac) {
		this.bac = bac;
	}

	// @Override ghi đè lại phương thức của lớp cha
	public String toString() {
		return "Cong Nhan [ Ho Ten=" + getHoTen() + ", Tuoi()=" + getTuoi() + ", Gioi Tinh()=" + getGioiTinh()
				+ ", Dia Chi()=" + getDiaChi() + ", bac=" + bac + "]";
	}
}
