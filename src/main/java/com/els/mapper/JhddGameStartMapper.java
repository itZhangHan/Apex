package com.els.mapper;

import com.els.bean.JhddGameStart;
import com.els.bean.JhddGameStartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JhddGameStartMapper {
    int countByExample(JhddGameStartExample example);

    int deleteByExample(JhddGameStartExample example);

    int deleteByPrimaryKey(Integer gameid);

    int insert(JhddGameStart record);

    int insertSelective(JhddGameStart record);

    List<JhddGameStart> selectByExample(JhddGameStartExample example);

    JhddGameStart selectByPrimaryKey(Integer gameid);

    int updateByExampleSelective(@Param("record") JhddGameStart record, @Param("example") JhddGameStartExample example);

    int updateByExample(@Param("record") JhddGameStart record, @Param("example") JhddGameStartExample example);

    int updateByPrimaryKeySelective(JhddGameStart record);

    int updateByPrimaryKey(JhddGameStart record);
}