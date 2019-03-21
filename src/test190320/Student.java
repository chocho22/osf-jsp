package test190320;

public class Student {
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "해당 학생의 이름은 : "
				+ name + "이며 나이는 " + age + "입니다.";
	}
}
