package upc.opendinghall.project.start.repository;

import org.springframework.data.repository.CrudRepository;
import upc.opendinghall.project.start.model.PictureInfo;

import java.util.List;

public interface PictureInfoRepository extends CrudRepository<PictureInfo,Long>
{
    public PictureInfo findByPictureid (String pictureid);

    List<PictureInfo> findAllByFoodid(long id);


}