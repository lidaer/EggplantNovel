package com.sz.eggplantnovel.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *章节发布 请求DTO
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/14
 */

@Data
@Builder
public class ChapterAddReqDto {
    /**
     * 小说ID
     */
    @Schema(description = "小说ID", required = true)
    private Long bookId;

    /**
     * 章节名
     */
    @NotBlank
    @Schema(description = "章节名", required = true)
    private String chapterName;

    /**
     * 章节内容
     */
    @Schema(description = "章节内容", required = true)
    @NotBlank
    @Length(min = 50)
    private String chapterContent;

    /**
     * 是否收费;1-收费 0-免费
     */
    @Schema(description = "是否收费;1-收费 0-免费", required = true)
    @NotNull
    private Integer isVip;
}
