package cn.lichenghao.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.util.HashSet;

@Configuration
public class ConverterServiceConfig {
	@Bean
	public ConversionServiceFactoryBean conversionService() {
		ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
		HashSet<Object> set = new HashSet<>();
		set.add(new OrgConverter());
		conversionServiceFactoryBean.setConverters(set);
		return conversionServiceFactoryBean;
	}
}
