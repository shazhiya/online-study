package com.shazhi.onlinestudy.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "courseware", schema = "online_study")
@Data
@Accessors(chain = true)
public class CoursewareEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coursewareId;
    private String coursewareDescription;
    private String coursewareName;
    private String coursewarePath;

    @OneToMany(mappedBy = "courseware")
    private Collection<BulletScreenEntity> bulletScreens;

    @OneToMany(mappedBy = "courseware")
    private Collection<CommentEntity> comments;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private ChapterEntity chapter;

    @ManyToOne
    @JoinColumn(name = "filetype_id")
    private FiletypeEntity filetype;

    @OneToMany(mappedBy = "courseware")
    private Collection<ProgressEntity> progresses;


}
