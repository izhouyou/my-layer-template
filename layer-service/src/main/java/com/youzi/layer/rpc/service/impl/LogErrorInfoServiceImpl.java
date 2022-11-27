package com.youzi.layer.rpc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youzi.layer.dao.domain.LogErrorInfo;
import com.youzi.layer.dao.mapper.LogErrorInfoMapper;
import com.youzi.layer.rpc.service.LogErrorInfoService;
import org.springframework.stereotype.Service;

/**
 * 操作日志异常信息(LogErrorInfo)表服务实现类
 *
 * @author izhouy
 * @since 2022-10-13 21:27:25
 */
@Service("logErrorInfoService")
public class LogErrorInfoServiceImpl extends ServiceImpl<LogErrorInfoMapper, LogErrorInfo> implements LogErrorInfoService {

}

