package com.els.mapper;

import com.els.bean.JhddPropsRecords;
import com.els.bean.JhddPropsRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JhddPropsRecordsMapper {
    int countByExample(JhddPropsRecordsExample example);

    int deleteByExample(JhddPropsRecordsExample example);

    int deleteByPrimaryKey(Integer userecordid);

    int insert(JhddPropsRecords record);

    int insertSelective(JhddPropsRecords record);

    List<JhddPropsRecords> selectByExample(JhddPropsRecordsExample example);

    JhddPropsRecords selectByPrimaryKey(Integer userecordid);

    int updateByExampleSelective(@Param("record") JhddPropsRecords record, @Param("example") JhddPropsRecordsExample example);

    int updateByExample(@Param("record") JhddPropsRecords record, @Param("example") JhddPropsRecordsExample example);

    int updateByPrimaryKeySelective(JhddPropsRecords record);

    int updateByPrimaryKey(JhddPropsRecords record);

	JhddPropsRecords selectByRoomId(Integer roomId);
}