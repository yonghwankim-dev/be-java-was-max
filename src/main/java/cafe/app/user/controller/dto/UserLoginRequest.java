package cafe.app.user.controller.dto;

import cafe.app.user.entity.User;

public class UserLoginRequest {

    //    @Pattern(regexp = "^[a-z\\d_-]{5,20}$", message = "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.")
    private String userId;
    //    @Pattern(regexp = "[A-Za-z\\d!@#$%^&*()_+]{8,16}$", message = "8~16자 영문 대 소문자, 숫자, 특수문자만 사용 가능합니다.")
    private String password;

    public UserLoginRequest() {
    }

    public UserLoginRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
            .userId(userId)
            .password(password)
            .build();
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserLoginRequest{" +
            "userId='" + userId + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
