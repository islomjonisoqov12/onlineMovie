package pro.kinokong.onlinemovies.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.kinokong.onlinemovies.criteria.base.GenericCriteria;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Criteria extends GenericCriteria {

    public String search = "%";

    public String getSearch() {
        return "%"+search.toLowerCase()+"%";
    }
}
