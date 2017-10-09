package com.els.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.els.bean.Gamehome;
import com.els.bean.GamehomeExample;

public interface GamehomeMapper {
    int countByExample(GamehomeExample example);

    int deleteByExample(GamehomeExample example);

    int deleteByPrimaryKey(Integer hid);

    int insert(Object user);

    int insertSelective(Gamehome record);

    List<Gamehome> selectByExample(GamehomeExample example);

    Gamehome selectByPrimaryKey(Integer hid);

    int updateByExampleSelective(@Param("record") Gamehome record, @Param("example") GamehomeExample example);

    int updateByExample(@Param("record") Gamehome record, @Param("example") GamehomeExample example);

    int updateByPrimaryKeySelective(Gamehome record);

    int updateByPrimaryKey(Gamehome record);

	int selectLastId();
}