package com.example.springbootbasic.controller.yaml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "")
public class LangArrYAML {

    private String[] lang;

    private UserYaml[] users;

    public String[] getLang() {
        return lang;
    }

    // set 方法不能少
    public void setLang(String[] lang) {
        this.lang = lang;
    }

    public UserYaml[] getUsers() {
        return users;
    }

    public void setUsers(UserYaml[] users) {
        this.users = users;
    }
}
