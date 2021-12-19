
package Reto2_web.repositorio;



import Reto2_web.interfaces.InterfaceCleaningProduct;
import Reto2_web.modelo.CleaningProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CleaningProductRepositorio {
    @Autowired
    private InterfaceCleaningProduct repository;

    public List<CleaningProduct> getAll() {
        return repository.findAll();
    }

    public Optional<CleaningProduct> getClothe(String reference) {
        return repository.findById(reference);
    }
    public CleaningProduct create(CleaningProduct clothe) {
        return repository.save(clothe);
    }

    public void update(CleaningProduct clothe) {
        repository.save(clothe);
    }
    
    public void delete(CleaningProduct clothe) {
        repository.delete(clothe);
    }
    
     public List<CleaningProduct> fintByPrice(double price){
        return repository.findByPrice(price);
    } 
    
    public List<CleaningProduct> findByDescriptionContainingIgnoreCase(String description){
        return repository.findByDescriptionContainingIgnoreCase(description);
    } 
}
