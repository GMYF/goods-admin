package com.light.springboot.core.domain.search;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 李振振
 * @version 1.0
 * @date 2021/3/26 9:44
 */
@Data
public class GoodInfo {
    @Getter
    @Setter
    private String goodId;

    @Getter
    @Setter
    private String goodType;

}
