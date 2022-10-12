package kodlamaIoArchitecture.business;

import kodlamaIoArchitecture.core.logging.ILogger;
import kodlamaIoArchitecture.dataAccess.IEducatorDao;
import kodlamaIoArchitecture.entities.Educator;

public class EducatorManager {
	private IEducatorDao _educatorDao;
	private ILogger[] _loggers;
	
	public EducatorManager(IEducatorDao educatorDao, ILogger[] loggers) {
		_educatorDao = educatorDao;
		_loggers = loggers;
	}
	
	public void add(Educator educator) throws Exception{
		_educatorDao.add(educator);
		
		for(ILogger logger : _loggers) {
			logger.log(educator.getName());
		}
	}
}
