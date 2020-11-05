package com.shazhi.onlinestudy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class ClazzUserPK implements Serializable {
    private Integer userId;
    private Integer clazzId;
}
