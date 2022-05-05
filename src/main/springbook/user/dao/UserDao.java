package main.springbook.user.dao;

import java.sql.*;
import main.springbook.user.domain.User;

import static main.springbook.ConnectionConst.*;

public class UserDao {

    /**
     * 커넥션 접근 코드를 메서드로 추출
     */

    public void add(User user) throws ClassNotFoundException, SQLException {
        //관심사 1. DB연결
        Connection c = getConnection();

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
        Connection c = getConnection();
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

    /**
     * 간단하지만 위험한 테스트 코드 ( DB의 데이터를 직접 삭제하지 않으면 두 번째 부터는 예외가 발생 )
     * id가 하드코딩 되어있다.
     */
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

    /**
     * 여러 메서드에 중복되어서 나타나는 특정 관심사항이 담긴 코드를 분리함. (Refactoring : extract method)
     */
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return c;
    }

}
