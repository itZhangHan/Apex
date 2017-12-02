package com.els.mapper;

import com.els.bean.JhddPositionimg;
import com.els.bean.JhddPositionimgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JhddPositionimgMapper {
    int countByExample(JhddPositionimgExample example);

    int deleteByExample(JhddPositionimgExample example);

    int deleteByPrimaryKey(Integer positionid);

    int insert(JhddPositionimg record);

    int insertSelective(JhddPositionimg record);

    List<JhddPositionimg> selectByExample(JhddPositionimgExample example);

    JhddPositionimg selectByPrimaryKey(Integer positionid);

    int updateByExampleSelective(@Param("record") JhddPositionimg record, @Param("example") JhddPositionimgExample example);

    int updateByExample(@Param("record") JhddPositionimg record, @Param("example") JhddPositionimgExample example);

    int updateByPrimaryKeySelective(JhddPositionimg record);

    int updateByPrimaryKey(JhddPositionimg record);
}