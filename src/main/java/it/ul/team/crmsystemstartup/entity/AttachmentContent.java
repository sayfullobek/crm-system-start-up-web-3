package it.revo.onlineshopweb3.entity;

import it.revo.onlineshopweb3.entity.templates.AbsEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AttachmentContent extends AbsEntity {

    @OneToOne
    private Attachment attachment;

    private byte[] bytes;
}
