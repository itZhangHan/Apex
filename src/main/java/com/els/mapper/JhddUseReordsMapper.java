package com.els.mapper;

import com.els.bean.JhddUseReords;
import com.els.bean.JhddUseReordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JhddUseReordsMapper {
    int countByExample(JhddUseReordsExample example);

    int deleteByExample(JhddUseReordsExample example);

    int deleteByPrimaryKey(Integer userecordid);

    int insert(JhddUseReords record);

    int insertSelective(JhddUseReords record);

    List<JhddUseReords> selectByExample(JhddUseReordsExample example);

    JhddUseReords selectByPrimaryKey(Integer userecordid);

    int updateByExampleSelective(@Param("record") JhddUseReords record, @Param("example") JhddUseReordsExample example);

    int updateByExample(@Param("record") JhddUseReords record, @Param("example") JhddUseReordsExample example);

    int updateByPrimaryKeySelective(JhddUseReords record);

    int updateByPrimaryKey(JhddUseReords record);
}