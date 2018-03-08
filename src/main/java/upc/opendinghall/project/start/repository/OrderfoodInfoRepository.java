package upc.opendinghall.project.start.repository;

import org.springframework.data.repository.CrudRepository;
import upc.opendinghall.project.start.model.OrderInfo;
import upc.opendinghall.project.start.model.OrderfoodInfo;

public interface OrderfoodInfoRepository extends CrudRepository<OrderfoodInfo,Long>
{
    public OrderInfo findByOrderfoodid(String orderoodid);

}
