package com.sz.eggplantnovel.service.serviceImpl;

import com.sz.eggplantnovel.core.common.resp.RestResp;
import com.sz.eggplantnovel.dto.resp.HomeBookRespDto;
import com.sz.eggplantnovel.dto.resp.HomeFriendLinkRespDto;
import com.sz.eggplantnovel.manager.Cache.FriendLinkCacheManager;
import com.sz.eggplantnovel.manager.Cache.HomeBookCacheManager;
import com.sz.eggplantnovel.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页模块 服务实现类
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/14
 */
@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final HomeBookCacheManager homeBookCacheManager;

    private final FriendLinkCacheManager friendLinkCacheManager;

    @Override
    public RestResp<List<HomeBookRespDto>> listHomeBooks() {
        return RestResp.ok(homeBookCacheManager.listHomeBooks());
    }

    @Override
    public RestResp<List<HomeFriendLinkRespDto>> listHomeFriendLinks() {
        return RestResp.ok(friendLinkCacheManager.listFriendLinks());
    }


}
