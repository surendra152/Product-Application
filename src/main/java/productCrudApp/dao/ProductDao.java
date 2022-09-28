package productCrudApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productCrudApp.model.Product;

@Component
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	


	//create ,to perform save operation we are using transaction annotation
	@Transactional 
	public void createproduct(Product product)
	{
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	
	//get all product
	public List<Product> getProducts()
	{
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		
		return  products;
	}
	
	
	//get the single product
	 
	public Product getProduct(int pid)
	{
		return this.hibernateTemplate.load(Product.class, pid);
	}
	
	//delete the single product
	@Transactional
	public void deleteProduct(int pid)
	{
		Product p = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(p);
	}
}
