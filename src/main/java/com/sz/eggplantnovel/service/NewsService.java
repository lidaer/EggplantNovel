package com.sz.eggplantnovel.service;

import com.sz.eggplantnovel.core.common.resp.RestResp;
import com.sz.eggplantnovel.dto.resp.NewsInfoRespDto;

import java.util.List;

/**
 * 新闻模块 服务类
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/20
 */

public interface NewsService {
    /**
     * 最新新闻列表查询
     *
     * @return 新闻列表
     */
    RestResp<List<NewsInfoRespDto>> listLatestNews();

    /**
     * 新闻信息查询
     *
     * @param id 新闻ID
     * @return 新闻信息
     */
    RestResp<NewsInfoRespDto> getNews(Long id);
}
