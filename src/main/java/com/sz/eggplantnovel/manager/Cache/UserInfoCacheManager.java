package com.sz.eggplantnovel.manager.Cache;

import com.sz.eggplantnovel.core.constant.CacheConsts;
import com.sz.eggplantnovel.dao.entity.UserInfo;
import com.sz.eggplantnovel.dao.mapper.UserInfoMapper;
import com.sz.eggplantnovel.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 用户信息 缓存管理类
 *
 * @author sz
 * @version 1.0
 * @date 2022/12/31
 */
@RequiredArgsConstructor
@Component
public class UserInfoCacheManager {

    private final UserInfoMapper userInfoMapper;

    /**
     * 查询用户信息，并放入缓存中
     */
    @Cacheable(cacheManager = CacheConsts.REDIS_CACHE_MANAGER,
            value = CacheConsts.USER_INFO_CACHE_NAME)
    public UserInfoDto getUser(Long userId) {
        UserInfo userInfo = userInfoMapper.selectById(userId);
        if (Objects.isNull(userInfo)) {
            return null;
        }
        return UserInfoDto.builder()
                .id(userInfo.getId())
                .status(userInfo.getStatus()).build();
    }
}
