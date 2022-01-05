package entity;

import java.time.LocalDate;

public class Article extends Document {
	private LocalDate ngayPhatHanh;

	public Article(int id, String nhaXuatBan, int soBanPhatHanh, LocalDate ngayPhatHanh) {
		super(id, nhaXuatBan, soBanPhatHanh);
		this.ngayPhatHanh = ngayPhatHanh;

	}

	@Override
	public String toString() {
		return "Article [Id()=" + getId() + ", NhaXuatBan()=" + getNhaXuatBan() + ", SoBanPhatHanh()="
				+ getSoBanPhatHanh() + ", ngayPhatHanh=" + ngayPhatHanh + "]";
	}
}
