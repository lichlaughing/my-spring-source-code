package cn.lichenghao.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class OrgConverter implements Converter<String, LocalDateTime> {
	@Override
	public LocalDateTime convert(String source) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.parse(source, dateTimeFormatter);
	}
}
