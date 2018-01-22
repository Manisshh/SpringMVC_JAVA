package mypack;

import java.util.List;

public interface ProductDAO {
	void add(Product ref);
	List<Product>viewProduct(String category);
	

}
