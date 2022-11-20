package com.sz.eggplantnovel.manager.Cache;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sz.eggplantnovel.core.constant.CacheConsts;
import com.sz.eggplantnovel.core.constant.DatabaseConsts;
import com.sz.eggplantnovel.dao.entity.AuthorInfo;
import com.sz.eggplantnovel.dao.mapper.AuthorInfoMapper;
import com.sz.eggplantnovel.dto.AuthorInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author sz
 * @version 1.0
 * @date 2022/11/20
 */

@RequiredArgsConstructor
@Component
public class AuthorInfoCacheManager {
    private final AuthorInfoMapper authorInfoMapper;

    /**
     * 查询作家信息，并放入缓存中
     */
    @Cacheable(cacheManager = CacheConsts.REDIS_CACHE_MANAGER,
            value = CacheConsts.AUTHOR_INFO_CACHE_NAME, unless = "#result == null")
    public AuthorInfoDto getAuthor(Long userId) {
        QueryWrapper<AuthorInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq(DatabaseConsts.AuthorInfoTable.COLUMN_USER_ID, userId)
                .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());
        AuthorInfo authorInfo = authorInfoMapper.selectOne(queryWrapper);
        if (Objects.isNull(authorInfo)) {
            return null;
        }
        return AuthorInfoDto.builder()
                .id(authorInfo.getId())
                .penName(authorInfo.getPenName())
                .status(authorInfo.getStatus()).build();
    }

    @CacheEvict(cacheManager = CacheConsts.REDIS_CACHE_MANAGER,
            value = CacheConsts.AUTHOR_INFO_CACHE_NAME)
    public void evictAuthorCache() {
        // 调用此方法自动清除作家信息的缓存
    }
}
