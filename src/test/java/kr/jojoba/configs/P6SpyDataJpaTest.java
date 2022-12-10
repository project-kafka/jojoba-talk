package kr.jojoba.configs;

import com.github.gavlyukovskiy.boot.jdbc.decorator.DataSourceDecoratorAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@DataJpaTest(showSql = false)
@ImportAutoConfiguration(DataSourceDecoratorAutoConfiguration.class)
@Import(TestQueryDSLConfig.class)
public @interface P6SpyDataJpaTest {
}
