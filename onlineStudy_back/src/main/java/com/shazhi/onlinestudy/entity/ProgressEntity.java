package com.shazhi.onlinestudy.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "progress", schema = "online_study")
@Data
@Accessors(chain = true)
public class ProgressEntity implements Serializable {

    @EmbeddedId
    private ProgressPK id;

    @MapsId("coursewareId")
    @ManyToOne
    @JoinColumn(name = "courseware_id")
    private CoursewareEntity courseware;

    @MapsId("clazzUser")
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "clazz_id"),@JoinColumn(name = "user_id")})
    private ClazzUserEntity clazzUser;


    private Byte progressFinished;
}
