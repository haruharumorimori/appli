package gatcha;

public class MasterBean {
	MasterBean(){}
	private String name;
	private String pass;
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
	MasterBean(String name,String pass){
		this.name=name;
		this.pass=pass;
	}
}
