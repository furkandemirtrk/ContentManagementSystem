package com.demirturk.cmscommons.entity.dto;

import com.demirturk.cmscommons.enums.Status;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseEntityDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String createdBy;
    private String updatedBy;
    private Integer version;
    private Status status;
}
