package upc.opendinghall.project.start.repository;

import org.springframework.data.repository.CrudRepository;
import upc.opendinghall.project.start.model.OrderInfo;

public interface OrderInfoRepository extends CrudRepository<OrderInfo,Long>{
    public  OrderInfo findByOrderid(long orderid);

}
