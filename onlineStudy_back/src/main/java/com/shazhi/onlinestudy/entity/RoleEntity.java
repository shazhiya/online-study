package com.shazhi.onlinestudy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "role", schema = "online_study")
@Data
@Accessors(chain = true)
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String roleName;

    @ManyToMany
    @JoinTable(name = "role_security",joinColumns = {@JoinColumn(name = "role_id")},inverseJoinColumns = {@JoinColumn(name = "security_id")})
    private Collection<SecurityEntity> securities;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Collection<UserEntity> users;
}
