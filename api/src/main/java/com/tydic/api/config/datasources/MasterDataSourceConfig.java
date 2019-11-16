package com.tydic.api.config.datasources;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = {"com.tydic.api.dao.master"},sqlSessionFactoryRef = "masterSessionFactory")
public class MasterDataSourceConfig {
	
	@Value("${api.datasource.master.driver-class-name:com.mysql.jdbc.Driver}")
	public String driverClass;
	@Value("${api.datasource.master.url}")
	public String url;
	@Value("${api.datasource.master.username}")
	public String username;
	@Value("${api.datasource.master.password}")
	public String password;
	
	@Value("${api.datasource.master.initial-size:10}")
	public int initialSize;
	@Value("${api.datasource.master.max-active:20}")
	public int maxActive;
	
	
	@Bean("masterDataSouce")
	@Primary
	public DataSource dataSouce() {
		DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName(driverClass);
		dds.setUrl(url);
		dds.setUsername(username);
		dds.setPassword(password);
		dds.setInitialSize(initialSize);
		dds.setMaxActive(maxActive);
		dds.setValidationQuery("select 1");
		dds.setTestOnBorrow(false);
		dds.setTestWhileIdle(true);
		dds.setPoolPreparedStatements(false);
		return dds;
	}
	
	/*@Bean("masterJdbcTemplate1")
	public NamedParameterJdbcTemplate masterJdbcTemplate(@Qualifier("masterDataSouce") DataSource datasouce) {
		return new NamedParameterJdbcTemplate(datasouce);
	}*/
	
	
	@Bean("masterSessionFactory")
	public SqlSessionFactory masterSessionFactory(@Qualifier("masterDataSouce") DataSource datasouce) throws Exception {
		SqlSessionFactoryBean sb = new SqlSessionFactoryBean();
		sb.setDataSource(datasouce);
		//设置映射文件
		sb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/master/*.xml"));
		return sb.getObject();
	}
	
	@Bean("masterJdbcTemplate")
	public SqlSessionTemplate masterJdbcTemplate(@Qualifier("masterSessionFactory") SqlSessionFactory sf) {
		return new SqlSessionTemplate(sf);
	}
	
}
