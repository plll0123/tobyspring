package main.springbook.user.dao;

import main.springbook.ConnectionConst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static main.springbook.ConnectionConst.*;

public class NUserDao implements ConnectionMaker{

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException{
        Connection c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return c;
    }
}
