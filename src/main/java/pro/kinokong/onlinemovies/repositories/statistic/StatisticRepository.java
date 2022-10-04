package pro.kinokong.onlinemovies.repositories.statistic;

import org.springframework.data.rest.core.annotation.RestResource;
import pro.kinokong.onlinemovies.entities.statistic.Statistic;
import pro.kinokong.onlinemovies.repositories.base.AbstractRepository;
@RestResource(exported = false)
public interface StatisticRepository extends AbstractRepository<Statistic, String> {
}
