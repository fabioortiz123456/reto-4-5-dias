package Reto2_web.repositorio;

import Reto2_web.interfaces.InterfaceOrder;
import Reto2_web.modelo.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class OrderRepository {
    @Autowired
    private InterfaceOrder interfaceOrder;
    
    public List<Order> getAll(){
        return interfaceOrder.findAll();
    }
    
      public Optional<Order> getOrder(Integer id){
        return interfaceOrder.findById(id);
    }
           
    public Order create(Order order) {
        return interfaceOrder.save(order);
    }

    public void update(Order order) {
        interfaceOrder.save(order);
    }
    
    public void delete(Order order) {
        interfaceOrder.delete(order);
    }
    
   
    public List<Order> getOrderByZone(String zone){
        return interfaceOrder.findBySalesManZone(zone);
    }
 
}
