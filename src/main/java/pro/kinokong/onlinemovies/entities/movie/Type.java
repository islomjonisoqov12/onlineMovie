package pro.kinokong.onlinemovies.entities.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.kinokong.onlinemovies.entities.base.BaseGenericEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "types")
public class Type implements BaseGenericEntity {

    @Id
//    @GeneratedValue
    String id = UUID.randomUUID().toString();

    @Column(nullable = false, unique = true)
    String name;
}
