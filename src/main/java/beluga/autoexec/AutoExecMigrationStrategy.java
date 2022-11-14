package beluga.autoexec;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;

/**
 * autoexec-script core base on flyway, but spring-boot dependency flyway version has version check, then import
 * autoexec-script make the progress throw NoSuchMethodError, so we need implements {@link FlywayMigrationStrategy}
 * to avoid spring-boot dependency check.
 * @author liull
 * @since 2022-11-14
 */
public class AutoExecMigrationStrategy implements FlywayMigrationStrategy {
    @Override
    public void migrate(Flyway flyway) {
        flyway.migrate();
    }
}
