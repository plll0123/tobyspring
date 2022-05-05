package main.springbook;

public interface ConnectionConst {

    //DB 연결을 위한 코드를 상수로 추출
    public static final String URL = "jdbc:mysql://localhost/springbook?characterEncoding=UTF-8";
    public static final String USERNAME = "spring";
    public static final String PASSWORD = "root";

}
