package gatcha;

public class GatchaBeans {
	private String name;
	private int star;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	GatchaBeans(){}

	GatchaBeans(String name,int star){
		this.name=name;
		this.star=star;
	}

	GatchaBeans(int id,String name,int star){
		this.name=name;
		this.star=star;
		this.id=id;
	}

}
