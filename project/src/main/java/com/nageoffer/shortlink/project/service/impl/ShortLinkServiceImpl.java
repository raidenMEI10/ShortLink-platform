package com.nageoffer.shortlink.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
import com.nageoffer.shortlink.project.dao.mapper.ShortLinkMapper;
import com.nageoffer.shortlink.project.service.ShortLinkService;
import org.springframework.stereotype.Service;

/**
 * 短链接服务实现类
 */
@Service
public class ShortLinkServiceImpl extends ServiceImpl<ShortLinkMapper, ShortLinkDO> implements ShortLinkService {
}
