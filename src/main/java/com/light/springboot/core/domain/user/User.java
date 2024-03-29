package com.light.springboot.core.domain.user;

import com.light.springboot.core.domain.account.Account;
import lombok.Data;

/**
 * @author zz.li
 * @Date 2019-07-31
 */
@Data
public class User {
    @lombok.Setter
    @lombok.Getter
    private Integer id;
    @lombok.Setter
    @lombok.Getter
    private String name;
    @lombok.Setter
    @lombok.Getter
    private String phone;
    @lombok.Setter
    @lombok.Getter
    private String token;
    @lombok.Setter
    @lombok.Getter
    private Account account;

    @Override
    public String toString() {
        String s = "\\%/g";
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
