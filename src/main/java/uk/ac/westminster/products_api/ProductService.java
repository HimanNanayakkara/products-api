package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products=new ArrayList<>();
    private Long nextId=1L;
    public ProductService() {
        products.add(new DigitalProduct(1L,"Windows 10",10.99,"www.micrisoft.com/windows10",20000));

        products.add(new PhysicalProduct(2L, "Gaming Laptop", 1299.99, 2.5, "35 x 25 x 2 cm"));

        nextId = 3L;
    }

    public List<Product> getAllProducts() {
        return products;
    }
    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream().filter(p->p.getId().equals(id)).findFirst();
    }
    public void deleteProduct(Long id) {
        products.removeIf(p->p.getId().equals(id));
    }
    public List<Product> findByName(String name) {
        return products.stream().filter(p->p.getName().contains(name)).toList();
    }

}
