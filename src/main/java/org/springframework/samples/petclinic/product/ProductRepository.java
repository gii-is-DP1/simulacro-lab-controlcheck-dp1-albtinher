package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer>{

    List<Product> findAll();
    
    @Query("SELECT pt FROM ProductType pt")
    List<ProductType> findAllProductTypes();
    
    Optional<Product> findById(int id);
    
    Product findByName(String name);

    @Query("SELECT pt FROM ProductType pt WHERE pt.name = :typeName")
    ProductType findProductTypeByName(String typeName);
    
    Product save(Product p);


    @Query("SELECT p FROM Product p WHERE p.price < :price")
    List<Product> findProductCheaperThan(double price);

}
