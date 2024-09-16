package vip.openpark.mysql.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import vip.openpark.mysql.domain.PersonEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anthony
 * @version 2024/9/16
 * @since 2024/9/16 15:17
 */
@Slf4j
@SpringBootTest
public class IPersonRepositoryTest {
	@Autowired
	private IPersonRepository personRepository;

	@Test
	@Sql(scripts = {"classpath:ddl.sql"}, statements = "DELETE FROM person WHERE 1=1")
	public void initDataTest() {
		// container
		List<PersonEntity> batchContainer = new ArrayList<>();

		// init data
		for (int i = 0; i < 10000; i++) {
			PersonEntity personEntity = new PersonEntity();
			personEntity.setId((long) i);
			personEntity.setRealName("anthony" + i);
			personEntity.setBirthday(LocalDateTime.now());
			personEntity.setSex((byte) (i % 2));
			personEntity.setMaritalStatus((byte) (i % 2));
			personEntity.setRemarkText("remarkText" + i);
			personEntity.setBlEnable((byte) (i % 2));
			personEntity.setBlDeleted((byte) (i % 2));
			personEntity.setVersionNumber(1L);
			personEntity.setGmtCreate(LocalDateTime.now());
			personEntity.setCreator("anthony");
			personEntity.setCreatorId(1L);
			personEntity.setCreatorCode("anthony");
			personEntity.setGmtModify(LocalDateTime.now());
			personEntity.setModifier("anthony");
			personEntity.setModifierId(1L);
			personEntity.setModifierCode("anthony");

			batchContainer.add(personEntity);
			if (batchContainer.size() == 100) {
				personRepository.saveAll(batchContainer);
				batchContainer.clear();
			}
		}
	}

}