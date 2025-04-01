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


import com.dao.DiscussyouxigonglueDao;
import com.entity.DiscussyouxigonglueEntity;
import com.service.DiscussyouxigonglueService;
import com.entity.vo.DiscussyouxigonglueVO;
import com.entity.view.DiscussyouxigonglueView;

@Service("discussyouxigonglueService")
public class DiscussyouxigonglueServiceImpl extends ServiceImpl<DiscussyouxigonglueDao, DiscussyouxigonglueEntity> implements DiscussyouxigonglueService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyouxigonglueEntity> page = this.selectPage(
                new Query<DiscussyouxigonglueEntity>(params).getPage(),
                new EntityWrapper<DiscussyouxigonglueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyouxigonglueEntity> wrapper) {
		  Page<DiscussyouxigonglueView> page =new Query<DiscussyouxigonglueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussyouxigonglueVO> selectListVO(Wrapper<DiscussyouxigonglueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyouxigonglueVO selectVO(Wrapper<DiscussyouxigonglueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyouxigonglueView> selectListView(Wrapper<DiscussyouxigonglueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyouxigonglueView selectView(Wrapper<DiscussyouxigonglueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
