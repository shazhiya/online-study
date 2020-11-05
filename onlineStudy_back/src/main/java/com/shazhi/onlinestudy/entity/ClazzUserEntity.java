package com.shazhi.onlinestudy.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "clazz_user")
@Data
@Accessors(chain = true)
public class ClazzUserEntity {

    @EmbeddedId
    private ClazzUserPK clazzUser;

    @MapsId("clazzId")
    @ManyToOne
    @JoinColumn(name = "clazz_id")
    private ClazzEntity clazz;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "clazzUser")
    private Collection<ProgressEntity> progresses;

}
