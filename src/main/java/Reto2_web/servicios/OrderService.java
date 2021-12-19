package Reto2_web.servicios;

import Reto2_web.modelo.Order;
import Reto2_web.repositorio.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    
     @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

  public Order create(Order order){
        if (order.getId() == null){
            return order;
        } else {
            return orderRepository.create(order);
        }
    }
  
 public Order update(Order order){
        if (order.getId() != null){
            Optional<Order> dbOrder = orderRepository.getOrder(order.getId());
            if (!dbOrder.isEmpty()) {

                if (order.getId() != null) {
                    dbOrder.get().setId(order.getId());
                }

                if (order.getRegisterDay() != null) {
                    dbOrder.get().setRegisterDay(order.getRegisterDay());
                }

                if (order.getStatus() != null) {
                    dbOrder.get().setStatus(order.getStatus());
                }

                if (order.getSalesMan() != null) {
                    dbOrder.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    dbOrder.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    dbOrder.get().setQuantities(order.getQuantities());
                }
                orderRepository.update(dbOrder.get());
                return dbOrder.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }


     public boolean delete(Integer id){
        return getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
    }
    
    public List<Order> getOrderByZone(String zone){
        return orderRepository.getOrderByZone(zone);
    }
    
    public List<Order> findByZone(String zone) {
        return orderRepository.findByZone(zone);
    }
    
    public List<Order> ordersSalesManByID(Integer id){
        return orderRepository.ordersSalesManByID(id);
    }
 
    public List<Order> ordersSalesManByState(String state, Integer id){
        return orderRepository.ordersSalesManByState(state, id);
    }
  
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        return orderRepository.ordersSalesManByDate(dateStr,id);
    }

}
