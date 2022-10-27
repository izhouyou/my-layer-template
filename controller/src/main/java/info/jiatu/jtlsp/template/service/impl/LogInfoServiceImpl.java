package info.jiatu.jtlsp.template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import info.jiatu.jtlsp.template.mapper.LogInfoMapper;
import info.jiatu.jtlsp.template.domain.LogInfo;
import info.jiatu.jtlsp.template.service.LogInfoService;
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

