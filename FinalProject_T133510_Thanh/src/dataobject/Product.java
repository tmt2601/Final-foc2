package dataobject;

public class Product {
	private int id;
	private String pCode;
	private String pName;
	private Category category;
	private Brand brand;
	private UnitOfMeasure unitofmeasure;
	private double pPrice;
	private String description;
	
	public Product(){
		id = 0;
		pCode = null;
		pName = null;
		category = null;
		brand = null;
		unitofmeasure = null;
		pPrice = 0;
		description = null;
	}
	public Product(int id, String pCode, String pName, Category category, Brand brand, UnitOfMeasure unitofmeasure,
			double pPrice, String description) {
		super();
		this.id = id;
		this.pCode = pCode;
		this.pName = pName;
		this.category = category;
		this.brand = brand;
		this.unitofmeasure = unitofmeasure;
		this.pPrice = pPrice;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", pCode=" + pCode + ", pName=" + pName + ", category=" + category + ", brand="
				+ brand + ", unitofmeasure=" + unitofmeasure + ", pPrice=" + pPrice + ", description=" + description
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public UnitOfMeasure getUnitofmeasure() {
		return unitofmeasure;
	}
	public void setUnitofmeasure(UnitOfMeasure unitofmeasure) {
		this.unitofmeasure = unitofmeasure;
	}
	public double getpPrice() {
		return pPrice;
	}
	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
