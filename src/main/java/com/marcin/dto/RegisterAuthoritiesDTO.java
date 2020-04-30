package com.marcin.dto;

public class RegisterAuthoritiesDTO {

    private String authority;
    private String username;
    private String userId;

    public RegisterAuthoritiesDTO(String authority, String username, String userId) {
        this.authority = authority;
        this.username = username;
        this.userId = userId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
