package select;
public class Teacher {
	private String teacher;
	private String id;
	private String sex;
	private String course;
	public Teacher(String teacher,String id,String sex,String course) {
		this.teacher=teacher;
		this.id=id;
		this.sex=sex;
		this.course=course;
	}
	public void SetCourse(String course) {
		this.course=course;
	}
	public String tostring() {
		return "教师信息("+"姓名:"+teacher+";性别:"+sex+";学号:"+id+";所授课程:"+course+")";
	}
}
