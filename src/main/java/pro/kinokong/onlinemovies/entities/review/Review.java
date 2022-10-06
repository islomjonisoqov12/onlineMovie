package pro.kinokong.onlinemovies.entities.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.kinokong.onlinemovies.entities.base.Auditable;
import pro.kinokong.onlinemovies.entities.movie.Movie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reviews")
public class Review extends Auditable {

    @Column(columnDefinition = "text", nullable = false)
    private String content;

    @ManyToOne(optional = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.EAGER)
    private Review parent;
}
