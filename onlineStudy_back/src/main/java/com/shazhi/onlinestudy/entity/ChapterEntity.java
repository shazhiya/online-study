package com.shazhi.onlinestudy.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "chapter", schema = "online_study", catalog = "")
@Data
@Accessors(chain = true)
public class ChapterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chapterId;
    private String chapterName;
    private String chapterCode;
    private String chapterDescription;

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private CurriculumEntity curriculum;

    @OneToMany(mappedBy = "chapter")
    private Collection<CoursewareEntity> coursewares;
}
