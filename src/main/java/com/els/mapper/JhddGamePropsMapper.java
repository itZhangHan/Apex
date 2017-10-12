package com.els.mapper;

import com.els.bean.JhddGameProps;
import com.els.bean.JhddGamePropsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JhddGamePropsMapper {
    int countByExample(JhddGamePropsExample example);

    int deleteByExample(JhddGamePropsExample example);

    int deleteByPrimaryKey(Integer gamepropsid);

    int insert(JhddGameProps record);

    int insertSelective(JhddGameProps record);

    List<JhddGameProps> selectByExample(JhddGamePropsExample example);

    JhddGameProps selectByPrimaryKey(Integer gamepropsid);

    int updateByExampleSelective(@Param("record") JhddGameProps record, @Param("example") JhddGamePropsExample example);

    int updateByExample(@Param("record") JhddGameProps record, @Param("example") JhddGamePropsExample example);

    int updateByPrimaryKeySelective(JhddGameProps record);

    int updateByPrimaryKey(JhddGameProps record);
}