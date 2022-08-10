package edu.school21.repositories;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class EmbeddedDataSourceTest {
    private DataSource dataSource;

    @BeforeEach
    void setDataSource()
    {
        dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScripts("schema.sql", "data.sql").build();
    }
    @Test
    void testGetConnection() throws SQLException
    {
        Connection connection;
        connection = dataSource.getConnection();
        Assertions.assertNotNull(connection);
    }
    @AfterEach
    void close() throws SQLException {
        dataSource.getConnection().close();
    }

}
