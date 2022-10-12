package kodlamaIoArchitecture.dataAccess;

import java.util.ArrayList;
import java.util.List;

import kodlamaIoArchitecture.entities.Educator;

public class HibernateEducatorDao implements IEducatorDao{
	private List<Educator> educators = new ArrayList<>();
	@Override
	public boolean add(Educator educator) {
		System.out.println("Hibernate ile veritabanına eklendi! : " + educator.getName());
		educators.add(educator);
		return true;
	}

}
