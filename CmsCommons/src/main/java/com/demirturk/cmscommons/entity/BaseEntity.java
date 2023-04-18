package com.demirturk.cmscommons.entity;

import com.demirturk.cmscommons.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime updatedDate = LocalDateTime.now();

    @Column(updatable = false)
    private String createdBy;

    @Column
    private String updatedBy;

    @Version
    @Column(nullable = false)
    private Integer version;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
}
