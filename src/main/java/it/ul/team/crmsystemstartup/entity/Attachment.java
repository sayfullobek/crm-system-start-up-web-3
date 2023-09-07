package it.revo.onlineshopweb3.entity;

import it.revo.onlineshopweb3.entity.templates.AbsEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Attachment extends AbsEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contentType;

    @Column(nullable = false)
    private Long size;


}
