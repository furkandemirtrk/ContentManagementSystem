package com.demirturk.cmscontentservice.entity;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
//@Audited
public class LargeText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;
}
