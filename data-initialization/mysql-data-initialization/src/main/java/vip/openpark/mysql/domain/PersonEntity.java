package vip.openpark.mysql.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author anthony
 * @version 2024/9/16
 * @since 2024/9/16 15:14
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "person")
public class PersonEntity {
	@Id
	private Long id;
	private String realName;
	private LocalDateTime birthday;
	private Byte sex;
	private Byte maritalStatus;
	private String remarkText;
	private Byte blEnable;
	private Byte blDeleted;
	private Long versionNumber;
	private LocalDateTime gmtCreate;
	private String creator;
	private Long creatorId;
	private String creatorCode;
	private LocalDateTime gmtModify;
	private String modifier;
	private Long modifierId;
	private String modifierCode;
}