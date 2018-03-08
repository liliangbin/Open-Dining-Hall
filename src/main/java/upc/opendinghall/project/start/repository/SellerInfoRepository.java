package upc.opendinghall.project.start.repository;

import org.springframework.data.repository.CrudRepository;
import upc.opendinghall.project.start.model.SellerInfo;

public interface SellerInfoRepository extends CrudRepository<SellerInfo,Long>
{
    public SellerInfo findBySellername (String sellername);


}
