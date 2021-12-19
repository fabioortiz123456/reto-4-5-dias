
package Reto2_web.interfaces;

import Reto2_web.modelo.CleaningProduct;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface InterfaceCleaningProduct extends MongoRepository<CleaningProduct, String> {
    public List<CleaningProduct> findByPrice(double price);
    public List<CleaningProduct> findByDescriptionContainingIgnoreCase(String description);
}

