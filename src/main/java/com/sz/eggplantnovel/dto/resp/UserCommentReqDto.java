package com.sz.eggplantnovel.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author sz
 * @version 1.0
 * @date 2022/11/14
 */
@Data
public class UserCommentReqDto {
    private Long userId;

    @Schema(description = "小说ID", required = true)
    @NotNull(message="小说ID不能为空！")
    private Long bookId;

    @Schema(description = "评论内容", required = true)
    @NotBlank(message="评论不能为空！")
    @Length(min = 10,max = 512)
    private String commentContent;
}
