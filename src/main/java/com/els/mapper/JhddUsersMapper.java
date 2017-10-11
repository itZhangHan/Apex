package com.els.mapper;

import com.els.bean.JhddUsers;
import com.els.bean.JhddUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JhddUsersMapper {
    int countByExample(JhddUsersExample example);

    int deleteByExample(JhddUsersExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(JhddUsers record);

    int insertSelective(JhddUsers record);

    List<JhddUsers> selectByExample(JhddUsersExample example);

    JhddUsers selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") JhddUsers record, @Param("example") JhddUsersExample example);

    int updateByExample(@Param("record") JhddUsers record, @Param("example") JhddUsersExample example);

    int updateByPrimaryKeySelective(JhddUsers record);

    int updateByPrimaryKey(JhddUsers record);
}