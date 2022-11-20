package com.sz.eggplantnovel.manager.Cache;

import com.sz.eggplantnovel.core.constant.CacheConsts;
import com.sz.eggplantnovel.dao.entity.BookChapter;
import com.sz.eggplantnovel.dao.mapper.BookChapterMapper;
import com.sz.eggplantnovel.dto.resp.BookChapterRespDto;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.C;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 小说章节 缓存管理类
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/17
 */
@Component
@RequiredArgsConstructor
public class BookChapterCacheManager {
    private final BookChapterMapper bookChapterMapper;

    /**
     * 查询小说章节信息，并放入缓存中
     */
    @Cacheable(cacheManager = CacheConsts.CAFFEINE_CACHE_MANAGER,
            value = CacheConsts.BOOK_CHAPTER_CACHE_NAME)
    public BookChapterRespDto getChapter(Long chapterId) {
        BookChapter bookChapter = bookChapterMapper.selectById(chapterId);
        return BookChapterRespDto.builder()
                .id(chapterId)
                .bookId(bookChapter.getBookId())
                .chapterNum(bookChapter.getChapterNum())
                .chapterName(bookChapter.getChapterName())
                .chapterWordCount(bookChapter.getWordCount())
                .chapterUpdateTime(bookChapter.getUpdateTime())
                .build();
    }
}
