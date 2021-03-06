package dao;

import java.sql.ResultSet;

public class courseDao {
	
	private final String GET_COURSES_QUERY = "SELECT c.course_id, c.course_name, c.format, c.semester, i.instructor_name FROM courses c, instructors i WHERE c.instructor_id = i.instructor_id";
	
	private final String GET_STUDENTS_IN_A_COURSE_QUERY = "SELECT c.course_name, s.student_name from students s, courses c, course_student cs\r\n" + 
			"WHERE c.course_id = ?\r\n" + 
			"AND cs.student_id = s.student_id\r\n" + 
			"AND c.course_id = cs.course_id";
	
	private final String GET_COURSES_BY_INSTRUCTOR_ID_QUERY = "SELECT i.instructor_name, i.instructor_id, i.instructor_email, c.course_name\r\n" + 
			"FROM courses c, instructors i\r\n" + 
			"WHERE i.instructor_id = ?\r\n" + 
			"AND c.instructor_id = i.instructor_id";
	
	private final String ADD_A_NEW_COURSE_QUERY = "INSERT INTO courses (instructor_id, course_name, course_format, semester) VALUES (?,?,?,?)";
	
	private final String DELETE_COURSE_BY_ID_QUERY = "DELETE from courses WHERE course_id = ?";
	
	private final String UPDATE_COURSE_BY_ID_QUERY = "UPDATE courses SET instructor_id = ?, course_name = ?, format = ?, semester = ? WHERE course_id = ?";
	
	public List <Courses> getCourses() {
		ResultSet rs = connection.prepareStatement(GET_COURSES_QUERY).executeQuery();
		List <Courses> courses = newArrayList <Courses>();
		while rs.next()){
			//I don't completely understand what Nick did here...but the idea is the results here get fed into display courses method in menu
		}
		return courses;
		}
	}
}
