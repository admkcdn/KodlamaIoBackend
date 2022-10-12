package kodlamaIoArchitecture.business;

import kodlamaIoArchitecture.core.logging.ILogger;
import kodlamaIoArchitecture.dataAccess.ICourseDao;
import kodlamaIoArchitecture.entities.Course;

public class CourseManager {
	private ICourseDao _courseDao;
	private ILogger[] _loggers;

	public CourseManager(ICourseDao courseDao, ILogger[] loggers) {
		_courseDao = courseDao;
		_loggers = loggers;
	}
	
	public void add(Course course) throws Exception{
		if(course.getPrice() <= 0) {
			throw new Exception("Kursun fiyatı 0'dan küçük olamaz");
		}
		
		if(_courseDao.add(course)) {
			for(ILogger logger : _loggers) {
				logger.log(course.getName());
			}
		}else {
			throw new Exception("Kurs ismi tekrarlanamaz!");
		}
	}
}
