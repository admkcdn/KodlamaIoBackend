package kodlamaIoArchitecture;

import kodlamaIoArchitecture.business.CategoryManager;
import kodlamaIoArchitecture.business.CourseManager;
import kodlamaIoArchitecture.core.logging.FileLogger;
import kodlamaIoArchitecture.core.logging.ILogger;
import kodlamaIoArchitecture.core.logging.MailLogger;
import kodlamaIoArchitecture.dataAccess.JdbcCategoryDao;
import kodlamaIoArchitecture.dataAccess.JdbcCourseDao;
import kodlamaIoArchitecture.entities.Category;
import kodlamaIoArchitecture.entities.Course;

public class Main {

	public static void main(String[] args) throws Exception {
		Category category = new Category(1, "Telefon");
		ILogger[] loggers = {new MailLogger(), new FileLogger()};
		
		Category category2 = new Category(2,"Bilgisayar");
		
		CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(), loggers);
		categoryManager.add(category);
		categoryManager.add(category2);
		
		
		Course course = new Course(1,"Java programlama","sıfırdan ileri seviye programlama",-69.99);
		Course course2 = new Course(1,"C# programlama","sıfırdan ileri seviye programlama",69.99);
		CourseManager courseManager = new CourseManager(new JdbcCourseDao(), loggers);
		courseManager.add(course);
		courseManager.add(course2);
		
	}

}
