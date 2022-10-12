package kodlamaIoArchitecture.dataAccess;

import java.util.ArrayList;
import java.util.List;

import kodlamaIoArchitecture.entities.Category;

public class HibernateCategoryDao implements ICategoryDao {
	private List<Category> categories = new ArrayList<>(); // DB bağlamadığımız için burada liste olarak tutuyorum.

	@Override
	public boolean add(Category category) {
		for (Category categoryDb : categories) {
			if (categoryDb.getName().equals(category.getName())) {
				return false;
			}
		}
		System.out.println("Hibernate ile veritabanına eklendi! : " + category.getName());
		categories.add(category);
		return true;

	}

}
