package main.springbook.user.dao;

public class DaoFactory {
    public UserDao getUserDao(){
        return new UserDao(getConnectionMaker());
    }

    public ConnectionMaker getConnectionMaker(){
        return new DConnectionMaker();
    }
}
