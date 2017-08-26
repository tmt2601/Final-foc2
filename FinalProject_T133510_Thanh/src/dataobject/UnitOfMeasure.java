package dataobject;

public class UnitOfMeasure {
	private int id;
	private String name;
	
	public UnitOfMeasure(){
		id = 0;
		name = null;
	};
	public UnitOfMeasure(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return name;
	}
		
}
