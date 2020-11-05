package com.shazhi.onlinestudy.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Table(name = "clazz", schema = "online_study")
@Data
@Accessors(chain = true)
public class ClazzEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String clazzName;
    private Integer clazzDescription;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private BatchEntity batch;

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private CurriculumEntity curriculum;

    @OneToMany(mappedBy = "clazz")
    private Collection<ClazzUserEntity> clazzUsers;


}
