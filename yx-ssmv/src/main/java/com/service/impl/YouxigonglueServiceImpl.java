package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YouxigonglueDao;
import com.entity.YouxigonglueEntity;
import com.service.YouxigonglueService;
import com.entity.vo.YouxigonglueVO;
import com.entity.view.YouxigonglueView;

@Service("youxigonglueService")
public class YouxigonglueServiceImpl extends ServiceImpl<YouxigonglueDao, YouxigonglueEntity> implements YouxigonglueService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YouxigonglueEntity> page = this.selectPage(
                new Query<YouxigonglueEntity>(params).getPage(),
                new EntityWrapper<YouxigonglueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YouxigonglueEntity> wrapper) {
		  Page<YouxigonglueView> page =new Query<YouxigonglueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YouxigonglueVO> selectListVO(Wrapper<YouxigonglueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YouxigonglueVO selectVO(Wrapper<YouxigonglueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YouxigonglueView> selectListView(Wrapper<YouxigonglueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YouxigonglueView selectView(Wrapper<YouxigonglueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
