package gatcha;

public class QuestionBeans {
	QuestionBeans(){}
	private String question;
	private String name;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	QuestionBeans(String question,String name){
		this.question=question;
		this.name=name;
	}
}
