package kodlamaIoArchitecture.business;


import kodlamaIoArchitecture.core.logging.ILogger;
import kodlamaIoArchitecture.dataAccess.ICategoryDao;
import kodlamaIoArchitecture.entities.Category;

public class CategoryManager {
	private ICategoryDao _categoryDao;
	private ILogger[] _loggers;
	

	public CategoryManager(ICategoryDao categoryDao, ILogger[] loggers) {
		_categoryDao = categoryDao;
		_loggers = loggers;
	}

	public void add(Category category) throws Exception {
		if(_categoryDao.add(category)) {
			for(ILogger logger : _loggers) {
				logger.log(category.getName());
			}
		}else {
			throw new Exception("Kategori ismi tekrar edemez!");
		}
	}
}
