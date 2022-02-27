package me.g1tommy.etfportfolioanalyzer.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class servicemeta {

    @Id
    public LocalDateTime basedate;
}
