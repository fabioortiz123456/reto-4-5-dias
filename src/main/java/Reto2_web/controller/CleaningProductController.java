
package Reto2_web.controller;


import Reto2_web.modelo.CleaningProduct;
import Reto2_web.servicios.CleaningProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/cleaningproduct")
@CrossOrigin("*")
public class CleaningProductController {
       @Autowired
    private CleaningProductService accessoryService;
       
     @GetMapping("/all")
    public List<CleaningProduct> getAll() {
        return accessoryService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<CleaningProduct> getClothe(@PathVariable("reference") String reference) {
        return accessoryService.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct create(@RequestBody CleaningProduct gadget) {
        return accessoryService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct gadget) {
        return accessoryService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return accessoryService.delete(reference);
    } 
    
    @GetMapping("/price/{price}")
    public List<CleaningProduct> fintByPrice(@PathVariable("price") double price){
       return accessoryService.fintByPrice(price);   
    }

    @GetMapping("/description/{description}")
    public List<CleaningProduct> findByDescriptionContainingIgnoreCase(@PathVariable("description") String description){
       return accessoryService.findByDescriptionContainingIgnoreCase(description);   
    }
}
