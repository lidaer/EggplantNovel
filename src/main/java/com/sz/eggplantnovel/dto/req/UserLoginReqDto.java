package com.sz.eggplantnovel.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 用户登录 请求Dto
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/11
 */

@Data
@Builder
public class UserLoginReqDto {
    @Schema(description = "手机号", required = true, example = "18888888888")
    @NotBlank(message = "手机号不能为空！")
    @Pattern(regexp = "^1[3|4|5|6|7|8|9][0-9]{9}$", message = "手机号格式不正确！")
    private String username;

    @Schema(description = "密码", required = true, example = "123456")
    @NotBlank(message = "密码不能为空！")
    private String password;
}
