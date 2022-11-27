package com.youzi.layer.web.controller;

import com.youzi.layer.common.util.ConvertUtils;
import com.youzi.layer.model.dto.LogInfoDto;
import com.youzi.layer.model.vo.LogInfoVo;
import com.youzi.layer.web.common.constant.LogAnnotConstants;
import com.youzi.layer.web.common.annotation.Log;
import com.youzi.layer.common.annotation.AddGroups;
import com.youzi.layer.common.annotation.UpdGroups;
import com.youzi.layer.common.response.Result;
import com.youzi.layer.common.util.ResultGeneratorUtils;
import com.youzi.layer.dao.domain.LogInfo;
import com.youzi.layer.rpc.service.LogInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 操作日志(LogInfo)表控制层
 *
 * @author izhouy
 * @since 2022-11-05 19:48:05
 */
@RestController
@RequestMapping("logInfo")
@Api(tags = "操作日志LogInfo表控制层")
@Validated
public class LogInfoController {
    /**
     * 服务对象
     */
    @Resource
    private LogInfoService logInfoService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param dto 查询实体
     * @return 所有数据
     */
    @GetMapping
    @ApiOperation("操作日志分页查询接口")
    public Result<IPage<LogInfo>> selectAll(Page<LogInfo> page, @Valid LogInfoDto dto) {
        return ResultGeneratorUtils.success();
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("操作日志根据主键id查询接口")
    @ApiImplicitParam(name = "id", value = "主键id", defaultValue = "1", required = true)
    public Result<LogInfoVo> selectOne(@NotNull(message = "id不能为空") @PathVariable Long id) {
        return ResultGeneratorUtils.success(ConvertUtils.convert(this.logInfoService.getById(id), LogInfoVo.class));
    }

    /**
     * 新增数据
     *
     * @param dto 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("操作日志新增接口")
    @Log(modul = "LogInfo", type = LogAnnotConstants.INSERT, desc = "操作日志新增接口")
    public Result<Boolean> insert(@Validated(AddGroups.class) @RequestBody LogInfoDto dto) {
        return ResultGeneratorUtils.success(this.logInfoService.save(ConvertUtils.convert(dto, LogInfo.class)));
    }

    /**
     * 修改数据
     *
     * @param dto 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("操作日志更新接口")
    @Log(modul = "LogInfo", type = LogAnnotConstants.UPDATE, desc = "操作日志更新接口")
    public Result<Boolean> update(@Validated(UpdGroups.class) @RequestBody LogInfoDto dto) {
        return ResultGeneratorUtils.success(this.logInfoService.updateById(ConvertUtils.convert(dto, LogInfo.class)));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ApiOperation("操作日志批量删除接口")
    @ApiImplicitParam(name = "idList", value = "主键id集合", defaultValue = "1,2", required = true)
    @Log(modul = "LogInfo", type = LogAnnotConstants.DELETE, desc = "操作日志删除接口")
    public Result<Boolean> delete(@RequestParam("idList") List<Long> idList) {
        return ResultGeneratorUtils.success(this.logInfoService.removeByIds(idList));
    }
}

