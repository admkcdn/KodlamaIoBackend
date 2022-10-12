package kodlamaIoArchitecture.dataAccess;

import java.util.ArrayList;
import java.util.List;

import kodlamaIoArchitecture.entities.Course;

public class JdbcCourseDao implements ICourseDao{
	private List<Course> courses = new ArrayList<>();
	
	
	@Override
	public boolean add(Course course) {
		for(Course courseDb : courses) {
			if (courseDb.getName().equals(course.getName())) {
				return false;
			}
		}
		System.out.println("Jdbc ile veritabanına eklendi! : " + course.getName());
		courses.add(course);
		return true;
	}
	
}
