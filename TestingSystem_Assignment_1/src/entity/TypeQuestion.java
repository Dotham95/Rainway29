package entity;

public class TypeQuestion {
	int id;
	TypeName name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TypeName getName() {
		return name;
	}

	public void setName(TypeName name) {
		this.name = name;
	}

	public String toString() {
		return "TypeQuestion [id=" + id + "]";
	}
}
