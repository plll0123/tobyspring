package main.springbook.user.dao;

import main.springbook.ConnectionConst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static main.springbook.ConnectionConst.*;

public class SimpleConnectionMaker {
    public  Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return c;
    }
}
