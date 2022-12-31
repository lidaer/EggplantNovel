package com.sz.eggplantnovel.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息 DTO
 *
 * @author sz
 * @version 1.0
 * @date 2022/12/31
 */
@Data
@Builder
public class UserInfoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer status;
}
