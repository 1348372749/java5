package select;
public class Course {
	private String course;
	private String id;
	private String score;
	private String location;
	private String time;
	private String teacher;
	public Course(String course,String id,String score,String location,String time,String teacher) {
		this.course=course;
		this.id=id;
		this.score=score;
		this.location=location;
		this.time=time;
		this.teacher=teacher;
	}
	public String GetCourse() {
		return course;
	}
	public void SetTeacher(String teacher) {
		this.teacher=teacher;
	}
	public String tostring() {
		return course+":"+"id:"+id+";ѧ��:"+score+";�ص�:"+location+";ʱ��:"+time+";��ʦ:"+teacher;
	}

}
