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
		return course+":"+"id:"+id+";学分:"+score+";地点:"+location+";时间:"+time+";教师:"+teacher;
	}

}
