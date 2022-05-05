package main.springbook.user.dao;

import main.springbook.ConnectionConst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static main.springbook.ConnectionConst.*;

public class DUserDao extends UserDao{

    // 커넥션을 가져오는 코드를 상속을 통해 확장
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return c;
    }
}
