package com.sz.eggplantnovel.service.serviceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sz.eggplantnovel.core.common.resp.PageRespDto;
import com.sz.eggplantnovel.core.common.resp.RestResp;
import com.sz.eggplantnovel.dao.entity.BookInfo;
import com.sz.eggplantnovel.dao.mapper.BookInfoMapper;
import com.sz.eggplantnovel.dto.req.BookSearchReqDto;
import com.sz.eggplantnovel.dto.resp.BookInfoRespDto;
import com.sz.eggplantnovel.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sz
 * @version 1.0
 * @date 2022/11/20
 */

@Service
@RequiredArgsConstructor
public class DbSearchServiceImpl implements SearchService {
    private final BookInfoMapper bookInfoMapper;

    @Override
    public RestResp<PageRespDto<BookInfoRespDto>> searchBooks(BookSearchReqDto condition) {
        Page<BookInfoRespDto> page = new Page<>();
        page.setCurrent(condition.getPageNum());
        page.setSize(condition.getPageSize());
        List<BookInfo> bookInfos = bookInfoMapper.searchBooks(page, condition);
        return RestResp.ok(
                PageRespDto.of(condition.getPageNum(), condition.getPageSize(), page.getTotal(),
                        bookInfos.stream().map(v -> BookInfoRespDto.builder()
                                .id(v.getId())
                                .bookName(v.getBookName())
                                .categoryId(v.getCategoryId())
                                .categoryName(v.getCategoryName())
                                .authorId(v.getAuthorId())
                                .authorName(v.getAuthorName())
                                .wordCount(v.getWordCount())
                                .lastChapterName(v.getLastChapterName())
                                .build()).collect(Collectors.toList())));
    }
}
