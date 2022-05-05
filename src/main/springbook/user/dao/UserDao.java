package main.springbook.user.dao;

import java.sql.*;
import main.springbook.user.domain.User;

import static main.springbook.ConnectionConst.*;

public class UserDao {

    /**
     * DB연결 코드가 DB에 접근하는 모든 메서드에 공통적으로 포함돼있음
     * DAO 메서드가 추가될 때마다 중복이 또 발생하고 연결하는 DB가 바뀐다면 하나하나 모두 바꿔줘야 한다.
     */
    public void add(User user) throws ClassNotFoundException, SQLException {
        //관심사 1. DB연결
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(URL, USERNAME,
                PASSWORD);

        //관심사 2. SQL 쿼리문 작성
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        // 사용한 리소스 반환
        ps.close();
        c.close();
    }


    public User get(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement ps = c
                .prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = new UserDao();

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }

}
