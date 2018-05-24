package gatcha;

public class GatchaBeans {
	private String name;
	private int star;
	private int id;
	private String explain;
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
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	GatchaBeans(){}

	GatchaBeans(String name,int star,String explain){
		this.name=name;
		this.star=star;
		this.explain=explain;
	}



	GatchaBeans(int id,String name,int star,String explain){
		this.id=id;
		this.name=name;
		this.star=star;
		this.explain=explain;
	}

}
