package com.shazhi.onlinestudy.entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Embeddable
public class ProgressPK implements Serializable {
    @Embedded
    private ClazzUserPK clazzUser;
    private Integer coursewareId;
}
