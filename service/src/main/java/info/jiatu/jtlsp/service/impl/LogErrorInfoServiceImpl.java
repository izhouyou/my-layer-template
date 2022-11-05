package info.jiatu.jtlsp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import info.jiatu.jtlsp.dao.domain.LogErrorInfo;
import info.jiatu.jtlsp.dao.mapper.LogErrorInfoMapper;
import info.jiatu.jtlsp.service.LogErrorInfoService;
import info.jiatu.jtlsp.service.LogErrorInfoService;
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

