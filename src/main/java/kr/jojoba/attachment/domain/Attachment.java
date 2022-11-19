package kr.jojoba.attachment.domain;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import kr.jojoba.commons.BaseTimeStamp;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

@Entity(name = "attachment")
@Getter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Audited
public class Attachment extends BaseTimeStamp {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "url", length = 500, nullable = false)
    private String url;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ext", length = 100, nullable = false)
    private String ext;
}
