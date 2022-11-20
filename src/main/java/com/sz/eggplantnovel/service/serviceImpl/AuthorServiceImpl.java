package com.sz.eggplantnovel.service.serviceImpl;

import com.sz.eggplantnovel.core.common.resp.RestResp;
import com.sz.eggplantnovel.dao.entity.AuthorInfo;
import com.sz.eggplantnovel.dao.mapper.AuthorInfoMapper;
import com.sz.eggplantnovel.dto.AuthorInfoDto;
import com.sz.eggplantnovel.dto.req.AuthorRegisterReqDto;
import com.sz.eggplantnovel.manager.Cache.AuthorInfoCacheManager;
import com.sz.eggplantnovel.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author sz
 * @version 1.0
 * @date 2022/11/20
 */

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorInfoCacheManager authorInfoCacheManager;

    private final AuthorInfoMapper authorInfoMapper;

    @Override
    public RestResp<Void> register(AuthorRegisterReqDto dto) {
        // 校验该用户是否已注册为作家
        AuthorInfoDto author = authorInfoCacheManager.getAuthor(dto.getUserId());
        if (Objects.nonNull(author)) {
            // 该用户已经是作家，直接返回
            return RestResp.ok();
        }
        // 保存作家注册信息
        AuthorInfo authorInfo = new AuthorInfo();
        authorInfo.setUserId(dto.getUserId());
        authorInfo.setChatAccount(dto.getChatAccount());
        authorInfo.setEmail(dto.getEmail());
        authorInfo.setInviteCode("0");
        authorInfo.setTelPhone(dto.getTelPhone());
        authorInfo.setPenName(dto.getPenName());
        authorInfo.setWorkDirection(dto.getWorkDirection());
        authorInfo.setCreateTime(LocalDateTime.now());
        authorInfo.setUpdateTime(LocalDateTime.now());
        authorInfoMapper.insert(authorInfo);
        // 清除作家缓存
        authorInfoCacheManager.evictAuthorCache();
        return RestResp.ok();
    }

    @Override
    public RestResp<Integer> getStatus(Long userId) {
        AuthorInfoDto author = authorInfoCacheManager.getAuthor(userId);
        return Objects.isNull(author) ? RestResp.ok(null) : RestResp.ok(author.getStatus());
    }
}
