package com.sz.eggplantnovel.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * @author sz
 * @version 1.0
 * @date 2022/11/14
 */

@Data
@Builder
public class BookCategoryRespDto {
    /**
     * 类别ID
     */
    @Schema(description = "类别ID")
    private Long id;

    /**
     * 类别名
     */
    @Schema(description = "类别名")
    private String name;
}
