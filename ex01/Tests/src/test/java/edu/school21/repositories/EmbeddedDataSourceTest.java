package edu.school21.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
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
        Assertions.assertNotNull(dataSource.getConnection());
    }
}
