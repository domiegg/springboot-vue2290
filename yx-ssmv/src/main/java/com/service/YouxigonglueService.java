package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YouxigonglueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YouxigonglueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YouxigonglueView;


/**
 * 游戏攻略
 *
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface YouxigonglueService extends IService<YouxigonglueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YouxigonglueVO> selectListVO(Wrapper<YouxigonglueEntity> wrapper);
   	
   	YouxigonglueVO selectVO(@Param("ew") Wrapper<YouxigonglueEntity> wrapper);
   	
   	List<YouxigonglueView> selectListView(Wrapper<YouxigonglueEntity> wrapper);
   	
   	YouxigonglueView selectView(@Param("ew") Wrapper<YouxigonglueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YouxigonglueEntity> wrapper);
   	
}

