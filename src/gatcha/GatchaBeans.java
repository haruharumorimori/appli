package gatcha;

public class GatchaBeans {
	private String name;
	private int star;
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
	GatchaBeans(){}

	GatchaBeans(String name,int star){
		this.name=name;
		this.star=star;
	}
}
