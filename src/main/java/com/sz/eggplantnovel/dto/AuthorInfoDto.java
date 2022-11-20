package com.sz.eggplantnovel.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author sz
 * @version 1.0
 * @date 2022/11/20
 */

@Data
@Builder
public class AuthorInfoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String penName;

    private Integer status;
}
