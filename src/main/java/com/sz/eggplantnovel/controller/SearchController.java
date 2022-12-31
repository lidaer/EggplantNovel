package com.sz.eggplantnovel.controller;

import com.sz.eggplantnovel.core.common.constant.ApiRouterConsts;
import com.sz.eggplantnovel.core.common.resp.PageRespDto;
import com.sz.eggplantnovel.core.common.resp.RestResp;
import com.sz.eggplantnovel.dto.req.BookSearchReqDto;
import com.sz.eggplantnovel.dto.resp.BookInfoRespDto;
import com.sz.eggplantnovel.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前台门户-搜索模块 API 控制器
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/21
 */
@Tag(name = "SearchController", description = "前台门户-搜索模块")
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_SEARCH_URL_PREFIX)
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    /**
     * 小说搜索接口
     */
    @Operation(summary = "小说搜索接口")
    @GetMapping("books")
    public RestResp<PageRespDto<BookInfoRespDto>> searchBooks(
            @ParameterObject BookSearchReqDto condition) {
        return searchService.searchBooks(condition);
    }
}
