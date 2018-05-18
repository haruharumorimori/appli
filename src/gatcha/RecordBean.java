package gatcha;

public class RecordBean {

	private String name;
	private String pass;
	private int stone;
	RecordBean(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getStone() {
		return stone;
	}
	public void setStone(int stone) {
		this.stone = stone;
	}
	RecordBean(String name,String pass,int stone){
		this.name=name;
		this.pass=pass;
		this.stone=stone;
	}
}
