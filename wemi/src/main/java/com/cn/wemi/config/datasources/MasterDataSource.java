package com.cn.wemi.config.datasources;


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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
/**
 * 主数据员配置
 * @author SHPolice
 */
@Configuration
@MapperScan(basePackages = {"com.cn.wemi.dao.master"},sqlSessionFactoryRef = "masterSqlSessionFactory",sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class MasterDataSource {
	
	@Value("${datasource.master.driver-class-name:com.mysql.jdbc.Driver}")
	public String driverClass;
	@Value("${datasource.master.url}")
	public String url;
	@Value("${datasource.master.username}")
	public String username;
	@Value("${datasource.master.password}")
	public String password;
	
	@Value("${datasource.master.initial-size:10}")
	public int initialSize;
	@Value("${datasource.master.max-active:20}")
	public int maxActive;
	
	@Value("${datasource.master.mapper-location:无}")
	public String mapperLocation;
	
	@Bean("masterDBData")
	@Primary
	public DataSource masterDataSource() {
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
	
	@Bean("masterSqlSessionFactory")
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDBData") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(dataSource);
		if(!"无".equals(mapperLocation)) {
			//设置映射文件
			ssfb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
		}
		
		return ssfb.getObject();
	}
	
	@Bean("masterSqlSessionTemplate")
	public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return  new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean("masterTransactionManager")
	public PlatformTransactionManager masterTransactionManager(@Qualifier("masterDBData") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
}
