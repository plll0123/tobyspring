package main.springbook.user.domain;

import lombok.Getter;
import lombok.Setter;

//자바빈 규약을 따르는 User클래스
@Getter @Setter
public class User {

    private String id;
    private String name;
    private String password;
}
