package entity;

import java.time.LocalDate;

public class Magazine extends Document {
	private int soPhatHanh;
	private LocalDate thangPhatHanh;

	public Magazine(int id, String nhaXuatBan, int soBanPhatHanh, int soPhatHanh, LocalDate thangPhatHanh) {
		super(id, nhaXuatBan, soBanPhatHanh);
		this.soPhatHanh = soPhatHanh;
		this.thangPhatHanh = thangPhatHanh;
	}

	@Override
	public String toString() {
		return "Magazine [Id()=" + getId() + ", NhaXuatBan()=" + getNhaXuatBan() + ", SoBanPhatHanh()="
				+ getSoBanPhatHanh() + ", soPhatHanh=" + soPhatHanh + ", thangPhatHanh=" + thangPhatHanh + "]";
	}
}
