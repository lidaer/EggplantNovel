package com.sz.eggplantnovel.service;

import com.sz.eggplantnovel.core.common.resp.RestResp;
import com.sz.eggplantnovel.dto.resp.HomeBookRespDto;
import com.sz.eggplantnovel.dto.resp.HomeFriendLinkRespDto;

import java.util.List;

/**
 * 主页模块 服务类
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/14
 */

public interface HomeService {

    /**
     * 查询首页小说推荐列表
     *
     * @return 首页小说推荐列表的rest 相应结果
     */
    RestResp<List<HomeBookRespDto>> listHomeBooks();

    /**
     * 首页友情链接列表查询
     *
     * @return 友情链接列表
     */
    RestResp<List<HomeFriendLinkRespDto>> listHomeFriendLinks();

}
