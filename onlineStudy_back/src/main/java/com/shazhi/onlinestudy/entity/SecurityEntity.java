package com.shazhi.onlinestudy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "security", schema = "online_study")
@Data
@Accessors(chain = true)
public class SecurityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer securityId;
    private String securityName;

    @ManyToMany(mappedBy = "securities")
    @JsonIgnore
    private Collection<RoleEntity> roleSecurities;
}
