package Com.edex.loginform.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Com.edex.loginform.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM PRODUCTS WHERE name = :name", nativeQuery = true )
    Product findByName(String name);

}