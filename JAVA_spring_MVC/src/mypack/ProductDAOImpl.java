package mypack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private HibernateTemplate template;
	@Override
	public void add(Product ref) {
		
		template.save(ref);
	}

	@Override
	public List<Product> viewProduct(String category) {
		List<Product> list=(List<Product>) template.find("from Product p where p.category=?", category);
		return list;
	}
	

}
