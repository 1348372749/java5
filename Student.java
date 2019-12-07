package select;

public class Student {
	String student;
	String id;
	String sex;
	String course;
	public Student(String student,String id,String sex,String course) {
		this.student=student;
		this.id=id;
		this.sex=sex;
		this.course=course;
	}
	public void SetCourse(String course) {
		this.course=course;
	}
	public void QuitCourse() {
		this.course="none";
	}
	public String tostring() {
		return "学生信息("+"姓名:"+student+";性别:"+sex+";学号:"+id+";所选课程:"+course+")";
	}
}
