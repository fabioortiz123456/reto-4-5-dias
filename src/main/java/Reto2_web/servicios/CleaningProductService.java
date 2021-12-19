
package Reto2_web.servicios;



import Reto2_web.modelo.CleaningProduct;
import Reto2_web.repositorio.CleaningProductRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CleaningProductService {
     @Autowired
    private CleaningProductRepositorio clotheRepository;

    public List<CleaningProduct> getAll() {
        return clotheRepository.getAll();
    }

   public Optional<CleaningProduct> getClothe(String reference) {
        return clotheRepository.getClothe(reference);
    }

    public CleaningProduct create(CleaningProduct accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return clotheRepository.create(accesory);
        }
    }

    public CleaningProduct update(CleaningProduct accesory) {

        if (accesory.getReference() != null) {
            Optional<CleaningProduct> accesoryDb = clotheRepository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                clotheRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
     public List<CleaningProduct> fintByPrice(double price){
        return clotheRepository.fintByPrice(price);
    }   
     
    public List<CleaningProduct> findByDescriptionContainingIgnoreCase(String description){
        return clotheRepository.findByDescriptionContainingIgnoreCase(description);
    } 
}

