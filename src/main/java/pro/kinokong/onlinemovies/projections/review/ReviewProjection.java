package pro.kinokong.onlinemovies.projections.review;

import org.springframework.beans.factory.annotation.Value;
import pro.kinokong.onlinemovies.dtos.base.BaseGenericDto;

import java.util.Map;

public interface ReviewProjection extends BaseGenericDto {

    String getId();

    String getContent();

    String getOwner();

    String getCreatedAt();

    @Value(value = "#{@movieServiceImpl.fromJsonToObject(target.parent_o)}")
    Object getParent();

}
