package com.els.mapper;

import com.els.bean.JhddGameInfo;
import com.els.bean.JhddGameInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JhddGameInfoMapper {
    int countByExample(JhddGameInfoExample example);

    int deleteByExample(JhddGameInfoExample example);

    int deleteByPrimaryKey(Integer gameid);

    int insert(JhddGameInfo record);

    int insertSelective(JhddGameInfo record);

    List<JhddGameInfo> selectByExample(JhddGameInfoExample example);

    JhddGameInfo selectByPrimaryKey(Integer gameid);

    int updateByExampleSelective(@Param("record") JhddGameInfo record, @Param("example") JhddGameInfoExample example);

    int updateByExample(@Param("record") JhddGameInfo record, @Param("example") JhddGameInfoExample example);

    int updateByPrimaryKeySelective(JhddGameInfo record);

    int updateByPrimaryKey(JhddGameInfo record);

	JhddGameInfo selectByRoomId(Integer roomId);

	void deleteByRoomId(String roomId);
}