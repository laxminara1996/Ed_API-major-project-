package in.laxmi.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CO_NOTICE")
@Setter
@Getter
public class CoNoticeEntity {
	@Id
	@GeneratedValue()
	private Integer noticeId;
	private Long caseNum;
	private String noticeStatus;
	private String noticeUrl;
	private Integer edgTraceId;
	private LocalDate noticePrintDate;
}
