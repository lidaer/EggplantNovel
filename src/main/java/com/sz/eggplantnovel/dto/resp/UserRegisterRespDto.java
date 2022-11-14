package com.sz.eggplantnovel.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * 用户注册 响应Dto
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/11
 */
@Data
@Builder
public class UserRegisterRespDto {
    @Schema(description = "用户ID")
    private Long uid;

    @Schema(description = "用户token")
    private String token;
}
