package com.sz.eggplantnovel.manager.Dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sz.eggplantnovel.core.constant.DatabaseConsts;
import com.sz.eggplantnovel.dao.entity.UserInfo;
import com.sz.eggplantnovel.dao.mapper.UserInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户模块 DAO管理类
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/20
 */
@Component
@RequiredArgsConstructor
public class UserDaoManager {
    private final UserInfoMapper userInfoMapper;

    /**
     * 根据用户ID集合批量查询用户信息列表
     *
     * @param userIds 需要查询的用户ID集合
     * @return 满足条件的用户信息列表
     */
    public List<UserInfo> listUsers(List<Long> userIds) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(DatabaseConsts.CommonColumnEnum.ID.getName(), userIds);
        return userInfoMapper.selectList(queryWrapper);
    }
}
