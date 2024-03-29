package com.light.springboot.core.domain.email;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 李振振
 * @version 1.0
 * @date 2019/10/30 17:04
 */
@Data
public class EmailConfig {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String host;
    @Getter
    @Setter
    private String sender;
    @Getter
    @Setter
    private String passWord;
    @Getter
    @Setter
    private Integer level;
}

