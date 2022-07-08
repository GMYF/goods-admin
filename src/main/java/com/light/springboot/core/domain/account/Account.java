package com.light.springboot.core.domain.account;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Account {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String no;
}
