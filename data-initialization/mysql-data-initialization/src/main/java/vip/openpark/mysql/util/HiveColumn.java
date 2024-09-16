package vip.openpark.mysql.util;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author anthony
 * @version 2024/9/16
 * @since 2024/9/16 16:05
 */
@Data
@Builder
public class HiveColumn {
	private String name;
	private String type;

	public static String getHiveColumnName(String fieldName) {
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : fieldName.toCharArray()) {
			if (c >= 'A' && c <= 'Z') {
				char lowerCase = (char) (c + 32);
				stringBuilder.append("_").append(lowerCase);
			} else {
				stringBuilder.append(c);
			}
		}

		return stringBuilder.toString();
	}

	public static String getHiveColumnType(Class<?> fieldType) {
		if (fieldType == String.class) {
			return "string";
		} else if (fieldType == Integer.class || fieldType == int.class) {
			return "int";
		} else if (fieldType == Long.class || fieldType == long.class) {
			return "bigint";
		} else if (fieldType == Float.class || fieldType == float.class) {
			return "float";
		} else if (fieldType == Double.class || fieldType == double.class) {
			return "double";
		} else if (fieldType == Boolean.class || fieldType == boolean.class) {
			return "boolean";
		} else if (fieldType == Byte.class || fieldType == byte.class) {
			return "tinyint";
		} else if (fieldType == Short.class || fieldType == short.class) {
			return "smallint";
		} else if (fieldType == Character.class || fieldType == char.class) {
			return "char";
		} else if (fieldType == Date.class || fieldType == LocalDate.class || fieldType == LocalDateTime.class) {
			return "date";
		} else {
			return "string";
		}
	}
}