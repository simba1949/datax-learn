package vip.openpark.mysql;

import com.alibaba.fastjson2.JSON;
import org.junit.jupiter.api.Test;
import vip.openpark.mysql.domain.PersonEntity;
import vip.openpark.mysql.util.HiveColumn;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anthony
 * @version 2024/9/16
 * @since 2024/9/16 16:02
 */
public class MySQLColumn2HiveColumnJsonUtilTest {

	@Test
	public void column2HiveColumnJson() {
		List<String> columns = new ArrayList<>();
		List<HiveColumn> hiveColumns = new ArrayList<>();

		Class<PersonEntity> aClass = PersonEntity.class;
		Field[] declaredFields = aClass.getDeclaredFields();
		for (Field declaredField : declaredFields) {
			declaredField.setAccessible(true);

			String fieldName = declaredField.getName();
			String hiveColumnName = HiveColumn.getHiveColumnName(fieldName);
			Class<?> fieldType = declaredField.getType();
			String hiveColumnType = HiveColumn.getHiveColumnType(fieldType);

			columns.add(hiveColumnName);

			HiveColumn hiveColumn = HiveColumn.builder().name(hiveColumnName).type(hiveColumnType).build();
			hiveColumns.add(hiveColumn);
		}

		System.out.println(JSON.toJSONString(columns));
		System.out.println(JSON.toJSONString(hiveColumns));
	}
}