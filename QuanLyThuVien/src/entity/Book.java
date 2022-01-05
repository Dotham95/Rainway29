package entity;

public class Book extends Document {
	private String tenTacGia;
	private int soTrang;

	public Book(int id, String nhaXuatBan, int soBanPhatHanh, String tenTacGia, int soTrang) {
		super(id, nhaXuatBan, soBanPhatHanh);
		this.tenTacGia = tenTacGia;
		this.soTrang = soTrang;

	}
	@Override
	public String toString() {
		return "Book [Id()=" + getId() + ", NhaXuatBan()=" + getNhaXuatBan() + ", SoBanPhatHanh()="
				+ getSoBanPhatHanh() + ", tenTacGia=" + tenTacGia + ", soTrang=" + soTrang + "]";
	}
}
