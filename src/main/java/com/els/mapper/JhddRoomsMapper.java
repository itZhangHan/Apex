package com.els.mapper;

import com.els.bean.JhddRooms;
import com.els.bean.JhddRoomsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JhddRoomsMapper {
    int countByExample(JhddRoomsExample example);

    int deleteByExample(JhddRoomsExample example);

    int deleteByPrimaryKey(Integer roomid);

    int insert(JhddRooms record);

    int insertSelective(JhddRooms record);

    List<JhddRooms> selectByExample(JhddRoomsExample example);

    JhddRooms selectByPrimaryKey(Integer roomid);

    int updateByExampleSelective(@Param("record") JhddRooms record, @Param("example") JhddRoomsExample example);

    int updateByExample(@Param("record") JhddRooms record, @Param("example") JhddRoomsExample example);

    int updateByPrimaryKeySelective(JhddRooms record);

    int updateByPrimaryKey(JhddRooms record);
}