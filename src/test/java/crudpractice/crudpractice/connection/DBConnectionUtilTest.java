package crudpractice.crudpractice.connection;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class DBConnectionUtilTest {

    @Test
    void connection () {
        Connection conn = DBConnectionUtil.getConnection();
        Assertions.assertThat(conn).isNotNull();
    }


}