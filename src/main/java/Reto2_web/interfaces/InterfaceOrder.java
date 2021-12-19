package Reto2_web.interfaces;

import Reto2_web.modelo.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;



public interface InterfaceOrder extends MongoRepository<Order, Integer> {
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);
    
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    Optional<Order> findTopByOrderByIdDesc();List<Order> findBySalesManZone(String zone);
   
   
}
