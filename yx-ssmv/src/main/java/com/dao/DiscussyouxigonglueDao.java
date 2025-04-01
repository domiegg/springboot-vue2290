package com.dao;

import com.entity.DiscussyouxigonglueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyouxigonglueVO;
import com.entity.view.DiscussyouxigonglueView;


/**
 * 游戏攻略评论表
 * 
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface DiscussyouxigonglueDao extends BaseMapper<DiscussyouxigonglueEntity> {
	
	List<DiscussyouxigonglueVO> selectListVO(@Param("ew") Wrapper<DiscussyouxigonglueEntity> wrapper);
	
	DiscussyouxigonglueVO selectVO(@Param("ew") Wrapper<DiscussyouxigonglueEntity> wrapper);
	
	List<DiscussyouxigonglueView> selectListView(@Param("ew") Wrapper<DiscussyouxigonglueEntity> wrapper);

	List<DiscussyouxigonglueView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyouxigonglueEntity> wrapper);
	
	DiscussyouxigonglueView selectView(@Param("ew") Wrapper<DiscussyouxigonglueEntity> wrapper);
	
}
