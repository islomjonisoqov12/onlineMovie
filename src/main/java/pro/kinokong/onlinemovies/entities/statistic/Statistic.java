package pro.kinokong.onlinemovies.entities.statistic;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.kinokong.onlinemovies.entities.base.BaseGenericEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "statistics")
public class Statistic implements BaseGenericEntity {

    @Id
//    @GeneratedValue
    private String id = UUID.randomUUID().toString();

    private int visitsNumber;

    @Column(nullable = false, unique = true)
    private LocalDate created = LocalDate.now();

}
