package com.dao;

import com.entity.YouxigonglueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YouxigonglueVO;
import com.entity.view.YouxigonglueView;


/**
 * 游戏攻略
 * 
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface YouxigonglueDao extends BaseMapper<YouxigonglueEntity> {
	
	List<YouxigonglueVO> selectListVO(@Param("ew") Wrapper<YouxigonglueEntity> wrapper);
	
	YouxigonglueVO selectVO(@Param("ew") Wrapper<YouxigonglueEntity> wrapper);
	
	List<YouxigonglueView> selectListView(@Param("ew") Wrapper<YouxigonglueEntity> wrapper);

	List<YouxigonglueView> selectListView(Pagination page,@Param("ew") Wrapper<YouxigonglueEntity> wrapper);
	
	YouxigonglueView selectView(@Param("ew") Wrapper<YouxigonglueEntity> wrapper);
	
}
