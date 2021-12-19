package Reto2_web.interfaces;

import Reto2_web.modelo.Order;
import java.util.List;
//import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;


public interface InterfaceOrder extends MongoRepository<Order, Integer> {
   List<Order> findBySalesManZone(String zone);
   
   
}
