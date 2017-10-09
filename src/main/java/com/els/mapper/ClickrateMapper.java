package com.els.mapper;

import com.els.bean.Clickrate;
import com.els.bean.ClickrateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClickrateMapper {
    int countByExample(ClickrateExample example);

    int deleteByExample(ClickrateExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Clickrate record);

    int insertSelective(Clickrate record);

    List<Clickrate> selectByExample(ClickrateExample example);

    Clickrate selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Clickrate record, @Param("example") ClickrateExample example);

    int updateByExample(@Param("record") Clickrate record, @Param("example") ClickrateExample example);

    int updateByPrimaryKeySelective(Clickrate record);

    int updateByPrimaryKey(Clickrate record);
}