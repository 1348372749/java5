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
		return "ѧ����Ϣ("+"����:"+student+";�Ա�:"+sex+";ѧ��:"+id+";��ѡ�γ�:"+course+")";
	}
}
