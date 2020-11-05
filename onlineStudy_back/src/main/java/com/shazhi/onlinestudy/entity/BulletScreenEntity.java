package com.shazhi.onlinestudy.entity;

import com.shazhi.onlinestudy.converter.JpaConverterJson;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bulletscreen", schema = "online_study")
@Data
@Accessors(chain = true)
public class BulletScreenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bulletscreen_id")
    private Integer bulletScreenId;

    @Convert(converter = JpaConverterJson.class)
    @Column(name = "bulletscreen_detail")
    private Object bulletScreenDetail;

    @Column(name = "bulletscreen_launchtime")
    private Timestamp bulletScreenLaunchTime;

    @Column(name = "bulletscreen_content")
    private String bulletScreenContent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "courseware_id")
    private CoursewareEntity courseware;
}
