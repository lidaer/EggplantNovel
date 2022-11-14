package com.sz.eggplantnovel.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sz.eggplantnovel.core.json.serializer.UserNameSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sz
 * @version 1.0
 * @date 2022/11/14
 */
public class BookComentRepDto {
    @Schema(description = "评论总数")
    private Long commentTotal;

    @Schema(description = "评论列表")
    private List<CommentInfo> comments;

    @Data
    @Builder
    public static class CommentInfo {

        @Schema(description = "评论ID")
        private Long id;

        @Schema(description = "评论内容")
        private String commentContent;

        @Schema(description = "评论用户")
        @JsonSerialize(using = UserNameSerializer.class)
        private String commentUser;

        @Schema(description = "评论用户ID")
        private Long commentUserId;

        @Schema(description = "评论用户头像")
        private String commentUserPhoto;

        @Schema(description = "评论时间")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime commentTime;

    }
}
