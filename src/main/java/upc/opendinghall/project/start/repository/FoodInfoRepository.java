package upc.opendinghall.project.start.repository;

import org.springframework.data.repository.CrudRepository;
import upc.opendinghall.project.start.model.FoodInfo;

public interface FoodInfoRepository  extends CrudRepository<FoodInfo,Long>{
    public FoodInfo findByFoodname(String foodname);

}