package beluga.autoexec;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Flyway.class)
@ConditionalOnExpression("${spring.flyway.enabled:false}||${flyway.enabled:false}")
public class AutoExecConfiguration {

    @Bean
    @ConditionalOnClass(FlywayMigrationStrategy.class)
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return new AutoExecMigrationStrategy();
    }
}
