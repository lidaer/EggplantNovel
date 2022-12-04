package com.sz.eggplantnovel.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @author sz
 * @version 1.0
 * @date 2022/11/14
 */
@Data
public class HomeFriendLinkRespDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 链接名
     */
    @Schema(description = "链接名")
    private String linkName;

    /**
     * 链接url
     */
    @Schema(description = "链接url")
    private String linkUrl;

}
