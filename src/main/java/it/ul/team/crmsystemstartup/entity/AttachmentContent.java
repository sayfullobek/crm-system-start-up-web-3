package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.templates.AbsEntity;
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
