/* Question 4 (Optional):
Một thư viện cần quản lý các tài liệu bao gồm   . Mỗi tài liệu gồm có các thuộc tính sau:
Document
Sách, Tạp chí, Báo
 Mã tài liệu(Mã tài liệu là duy nhất),
 Tên nhà xuất bản, số bản phát hành.*/

package entity;

public class Document {
	private int id;
	private String nhaXuatBan;
	private int soBanPhatHanh;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public int getSoBanPhatHanh() {
		return soBanPhatHanh;
	}

	public void setSoBanPhatHanh(int soBanPhatHanh) {
		this.soBanPhatHanh = soBanPhatHanh;
	}

	public Document() {
		super();
	}

	public Document(int id, String nhaXuatBan, int soBanPhatHanh) {
		super();
		this.id = id;
		this.nhaXuatBan = nhaXuatBan;
		this.soBanPhatHanh = soBanPhatHanh;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", nhaXuatBan=" + nhaXuatBan + ", soBanPhatHanh=" + soBanPhatHanh + "]";
	}

}
