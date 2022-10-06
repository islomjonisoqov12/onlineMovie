package pro.kinokong.onlinemovies.criteria;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pro.kinokong.onlinemovies.criteria.base.GenericCriteria;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieCriteria extends GenericCriteria {

    private List<String> genres;

    private List<String> actors;

    private String type;

    private String search;

    private String sortBy;

    private String sortDirection;


    @Hidden
    public String getActorsForSearch() {
        return actors != null && actors.size()>0? actors.toString(): "%";
    }

    @Hidden
    public String getGenresForSearch() {
        return genres != null && genres.size()>0? genres.toString(): "%";
    }

    @Hidden
    public String getSearchFormatted() {
        return search!=null && !search.isBlank() && !search.isEmpty()? "%"+search+"%":"%";
    }

    @Hidden
    public String getSortFilter(){
        if (sortDirection == null || sortDirection.isEmpty() || sortDirection.isBlank() || sortDirection.equalsIgnoreCase("asc")) {
            return sortBy.replaceAll("([A-Z])", "_$1").toLowerCase();
        }else {
            return sortBy.replaceAll("([A-Z])", "_$1").toLowerCase()+" "+"desc";
        }
    }

    @Hidden
    public String getTypeForSearch() {
        return type!=null && !type.isEmpty() && !type.isBlank()? type: "%";
    }

    @Hidden
    public Pageable getPageable(boolean isCamelCase) {
        String s = isCamelCase? sortBy: sortBy.replaceAll("([A-Z])", "_$1").toLowerCase();
        if (sortDirection == null || sortDirection.isEmpty() || sortDirection.isBlank() || sortDirection.equalsIgnoreCase("asc")) {
            return PageRequest.of(page, size, Sort.Direction.ASC, s);
        }else {
            return PageRequest.of(page, size, Sort.Direction.DESC, s);
        }
    }
}
