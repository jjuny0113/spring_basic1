package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //default는 위의 package를 다 스캔한다.
        //scan 시작위치 지정
        basePackages = "hello.core.member", //
        basePackageClasses = AutoAppConfig.class,
        // 스캔 줄 뺄것 지정(예제 코드를 유지하기 위해서)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

}
