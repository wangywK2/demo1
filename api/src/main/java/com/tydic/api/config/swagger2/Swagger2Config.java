package com.tydic.api.config.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * swagger2 配置文件
 * 启动类增加@EnableSwagger2 启动swagger2
 * @Api 用在请求的类上，表示对类的说明
 * @ApiOperation 用在请求的方法上，说明方法的用途、作用  ；value="说明方法的用途、作用"；notes="方法的备注说明"
 * 
 * @ApiImplicitParams @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
 * @author SHPolice
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(aipInfo())
				.select().apis(RequestHandlerSelectors.basePackage("com.tydic.api.controller"))
				.paths(PathSelectors.any()).build();
	}
	private ApiInfo aipInfo() {
		return new ApiInfoBuilder().title("黄浦支队·数据可视化").description("描述:Restful接口").version("V.1.0.0").build();
	}
}
