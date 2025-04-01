package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyouxigonglueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyouxigonglueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyouxigonglueView;


/**
 * 游戏攻略评论表
 *
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface DiscussyouxigonglueService extends IService<DiscussyouxigonglueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyouxigonglueVO> selectListVO(Wrapper<DiscussyouxigonglueEntity> wrapper);
   	
   	DiscussyouxigonglueVO selectVO(@Param("ew") Wrapper<DiscussyouxigonglueEntity> wrapper);
   	
   	List<DiscussyouxigonglueView> selectListView(Wrapper<DiscussyouxigonglueEntity> wrapper);
   	
   	DiscussyouxigonglueView selectView(@Param("ew") Wrapper<DiscussyouxigonglueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyouxigonglueEntity> wrapper);
   	
}

