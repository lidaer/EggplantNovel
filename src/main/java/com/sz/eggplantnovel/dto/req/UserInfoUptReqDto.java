package com.sz.eggplantnovel.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 用户信息修改 请求Dto
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/11
 */
@Data
@Builder
public class UserInfoUptReqDto {
    private Long userId;

    @Schema(description = "昵称")
    @Length(min = 2,max = 10)
    private String nickName;

    @Schema(description = "头像地址")
    private String userPhoto;

    @Schema(description = "性别")
    @Min(value = 0)
    @Max(value = 1)
    private Integer userSex;
}
