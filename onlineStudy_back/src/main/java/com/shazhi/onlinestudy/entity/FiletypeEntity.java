package com.shazhi.onlinestudy.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "filetype", schema = "online_study")
@Data
@Accessors(chain = true)
public class FiletypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filetypeId;
    private String filetypeName;
    private String filetypeDescription;

    @OneToMany(mappedBy = "filetype")
    private Collection<CoursewareEntity> coursewares;
}
