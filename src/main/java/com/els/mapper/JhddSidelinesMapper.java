package com.els.mapper;

import com.els.bean.JhddSidelines;
import com.els.bean.JhddSidelinesExample;
import com.els.bean.JhddUsers;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JhddSidelinesMapper {
	int countByExample(JhddSidelinesExample example);

	int deleteByExample(JhddSidelinesExample example);

	int deleteByPrimaryKey(Integer sidelinesid);

	int insert(JhddSidelines record);

	int insertSelective(JhddSidelines record);

	List<JhddSidelines> selectByExample(JhddSidelinesExample example);

	JhddSidelines selectByPrimaryKey(Integer sidelinesid);

	int updateByExampleSelective(@Param("record") JhddSidelines record, @Param("example") JhddSidelinesExample example);

	int updateByExample(@Param("record") JhddSidelines record, @Param("example") JhddSidelinesExample example);

	int updateByPrimaryKeySelective(JhddSidelines record);

	int updateByPrimaryKey(JhddSidelines record);

	JhddSidelines selectLastSidelines();

	int selectRoomId(Integer sidelinesId);

	List<JhddSidelines> selectJhddSidelinesByUserId(int userid);

	JhddSidelines selectUserBelongRoom(Integer userid);

	Integer selectUserStatusByUserid(Integer userid);

	List<Integer> selectUserIdsByRoomId(Integer roomid);

	List<JhddUsers> selectUsersInfoByRoomId(Integer roomid);
}