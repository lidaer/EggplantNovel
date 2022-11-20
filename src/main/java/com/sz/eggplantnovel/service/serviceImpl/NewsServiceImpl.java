package com.sz.eggplantnovel.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sz.eggplantnovel.core.common.resp.RestResp;
import com.sz.eggplantnovel.core.constant.DatabaseConsts;
import com.sz.eggplantnovel.dao.entity.NewsContent;
import com.sz.eggplantnovel.dao.entity.NewsInfo;
import com.sz.eggplantnovel.dao.mapper.NewsContentMapper;
import com.sz.eggplantnovel.dao.mapper.NewsInfoMapper;
import com.sz.eggplantnovel.dto.resp.NewsInfoRespDto;
import com.sz.eggplantnovel.manager.Cache.NewsCacheManager;
import com.sz.eggplantnovel.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sz
 * @version 1.0
 * @date 2022/11/20
 */
@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsCacheManager newsCacheManager;

    private final NewsInfoMapper newsInfoMapper;

    private final NewsContentMapper newsContentMapper;

    @Override
    public RestResp<List<NewsInfoRespDto>> listLatestNews() {
        return RestResp.ok(newsCacheManager.listLatestNews());
    }

    @Override
    public RestResp<NewsInfoRespDto> getNews(Long id) {
        NewsInfo newsInfo = newsInfoMapper.selectById(id);
        QueryWrapper<NewsContent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DatabaseConsts.NewsContentTable.COLUMN_NEWS_ID, id)
                .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());
        NewsContent newsContent = newsContentMapper.selectOne(queryWrapper);
        return RestResp.ok(NewsInfoRespDto.builder()
                .title(newsInfo.getTitle())
                .sourceName(newsInfo.getSourceName())
                .updateTime(newsInfo.getUpdateTime())
                .content(newsContent.getContent())
                .build());
    }
}
