package com.sz.eggplantnovel.service;

import com.sz.eggplantnovel.core.common.resp.PageRespDto;
import com.sz.eggplantnovel.core.common.resp.RestResp;
import com.sz.eggplantnovel.dto.req.BookSearchReqDto;
import com.sz.eggplantnovel.dto.resp.BookInfoRespDto;

/**
 * 搜索 服务类
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/20
 */
public interface SearchService {
    /**
     * 小说搜索
     *
     * @param condition 搜索条件
     * @return 搜索结果
     */
    RestResp<PageRespDto<BookInfoRespDto>> searchBooks(BookSearchReqDto condition);
}
