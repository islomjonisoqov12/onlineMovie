package pro.kinokong.onlinemovies.entities.movie;

import pro.kinokong.onlinemovies.entities.base.Auditable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "actors")
public class Actor extends Auditable {

    @Column(nullable = false, unique = true)
    private String fullName;

    @Column(columnDefinition = "text")
    private String avatar;

}
