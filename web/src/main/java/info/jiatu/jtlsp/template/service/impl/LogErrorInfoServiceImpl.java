package info.jiatu.jtlsp.template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import info.jiatu.jtlsp.template.mapper.LogErrorInfoMapper;
import info.jiatu.jtlsp.template.domain.LogErrorInfo;
import info.jiatu.jtlsp.template.service.LogErrorInfoService;
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

