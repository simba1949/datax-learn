package vip.openpark.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vip.openpark.mysql.domain.PersonEntity;

/**
 * @author anthony
 * @version 2024/9/16
 * @since 2024/9/16 15:09
 */
@Repository
public interface IPersonRepository extends JpaRepository<PersonEntity, Long> {
}