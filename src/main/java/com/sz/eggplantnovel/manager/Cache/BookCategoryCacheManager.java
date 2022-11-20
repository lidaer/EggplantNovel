package com.sz.eggplantnovel.manager.Cache;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sz.eggplantnovel.core.constant.CacheConsts;
import com.sz.eggplantnovel.core.constant.DatabaseConsts;
import com.sz.eggplantnovel.dao.entity.BookCategory;
import com.sz.eggplantnovel.dao.mapper.BookCategoryMapper;
import com.sz.eggplantnovel.dto.resp.BookCategoryRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 小说分类 缓存管理类
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/17
 */

@Component
@RequiredArgsConstructor
public class BookCategoryCacheManager {
    private final BookCategoryMapper bookCategoryMapper;

    /**
     * 根据作品方向查询小说分类列表，并放入缓存中
     */
    @Cacheable(cacheManager = CacheConsts.CAFFEINE_CACHE_MANAGER,
            value = CacheConsts.BOOK_CATEGORY_LIST_CACHE_NAME)
    public List<BookCategoryRespDto> listCategory(Integer workDirection) {
        QueryWrapper<BookCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DatabaseConsts.BookCategoryTable.COLUMN_WORK_DIRECTION, workDirection);
        return bookCategoryMapper.selectList(queryWrapper).stream().map(v ->
                BookCategoryRespDto.builder()
                        .id(v.getId())
                        .name(v.getName())
                        .build()).collect(Collectors.toList());
    }
}
