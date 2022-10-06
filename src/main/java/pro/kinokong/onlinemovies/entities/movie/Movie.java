package pro.kinokong.onlinemovies.entities.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.kinokong.onlinemovies.entities.base.Auditable;
import pro.kinokong.onlinemovies.entities.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "movies")
public class Movie extends Auditable {

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, columnDefinition = "date default now()")
    private LocalDate releaseDate = LocalDate.now();

    private Integer ratingCount;

    private Integer ratingAmount;

    private int duration;

    @Column(columnDefinition = "text")
    private String videoLink;

    @Column(columnDefinition = "text")
    private String thriller;

    @Column(columnDefinition = "text")
    private String image;


    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    private Type type;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "likes", uniqueConstraints = {@UniqueConstraint(columnNames = {"movies_id", "like_id"})})
    private List<User> like = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dislikes", uniqueConstraints = {@UniqueConstraint(columnNames = {"movies_id", "dislike_id"})})
    private List<User> dislike = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(uniqueConstraints = {@UniqueConstraint(columnNames = {"movies_id", "qualities_id"})})
    private List<Quality> qualities = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(uniqueConstraints = {@UniqueConstraint(columnNames = {"movies_id", "genres_id"})})
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(uniqueConstraints = {@UniqueConstraint(columnNames = {"movies_id", "countries_id"})})
    private List<Country> countries = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(uniqueConstraints = {@UniqueConstraint(columnNames = {"movies_id", "actors_id"})})
    private List<Actor> actors = new ArrayList<>();


}
