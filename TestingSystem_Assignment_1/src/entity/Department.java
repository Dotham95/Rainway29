package entity;

public class Department {
	public int id;
	public String name;

	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Department() {
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}