package io.github.linghengqian;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@Testcontainers
public class SimpleTest {

    @SuppressWarnings("resource")
    @Container
    private final GenericContainer<?> container = new GenericContainer<>("apache/hive:4.0.1")
            .withEnv("SERVICE_NAME", "hiveserver2")
            .withExposedPorts(10000);

    private final String absolutePath = Paths.get("src/test/resources/test.sql").toAbsolutePath().toString();

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void test() throws SQLException {
        assertThat(absolutePath.contains("\\hive-init-file-windows-test\\src\\test\\resources\\test.sql"), is(true));
        String jdbcUrlPrefix = "jdbc:hive2://" + container.getHost() + ":" + container.getMappedPort(10000) + "/";
        Awaitility.await().atMost(Duration.ofMinutes(1L)).ignoreExceptions().until(() -> {
            DriverManager.getConnection(jdbcUrlPrefix).close();
            return true;
        });
        try (Connection connection = DriverManager.getConnection(jdbcUrlPrefix)) {
            connection.createStatement().execute("CREATE DATABASE demo_ds_0");
        }
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.apache.hive.jdbc.HiveDriver");
        config.setJdbcUrl(jdbcUrlPrefix + "demo_ds_0" + ";initFile=" + absolutePath);
        assertDoesNotThrow(() -> {
            try (HikariDataSource dataSource = new HikariDataSource(config)) {
                dataSource.getConnection();
            }
        });
    }
}
