package info.jiatu.jtlsp.template.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import info.jiatu.jtlsp.template.domain.LogInfo;

/**
 * 操作日志(LogInfo)表数据库访问层
 *
 * @author izhouy
 * @since 2022-10-13 21:27:25
 */
@Mapper
public interface LogInfoMapper extends BaseMapper<LogInfo> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<LogInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<LogInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<LogInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<LogInfo> entities);

}

