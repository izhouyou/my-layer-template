package com.youzi.layer.rpc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youzi.layer.dao.domain.LogInfo;
import com.youzi.layer.dao.mapper.LogInfoMapper;
import com.youzi.layer.rpc.service.LogInfoService;
import org.springframework.stereotype.Service;

/**
 * 操作日志(LogInfo)表服务实现类
 *
 * @author izhouy
 * @since 2022-10-13 21:27:26
 */
@Service("logInfoService")
public class LogInfoServiceImpl extends ServiceImpl<LogInfoMapper, LogInfo> implements LogInfoService {

}

