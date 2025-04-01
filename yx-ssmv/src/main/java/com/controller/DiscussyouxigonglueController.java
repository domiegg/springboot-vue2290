package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.entity.YonghuEntity;
import com.service.YonghuService;
import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussyouxigonglueEntity;
import com.entity.view.DiscussyouxigonglueView;

import com.service.DiscussyouxigonglueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 游戏攻略评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
@RestController
@RequestMapping("/discussyouxigonglue")
public class DiscussyouxigonglueController {
    @Autowired
    private DiscussyouxigonglueService discussyouxigonglueService;
    @Autowired
    private YonghuService yonghuService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussyouxigonglueEntity discussyouxigonglue, HttpServletRequest request){

        EntityWrapper<DiscussyouxigonglueEntity> ew = new EntityWrapper<DiscussyouxigonglueEntity>();
		PageUtils page = discussyouxigonglueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyouxigonglue), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussyouxigonglueEntity discussyouxigonglue, HttpServletRequest request){
        EntityWrapper<DiscussyouxigonglueEntity> ew = new EntityWrapper<DiscussyouxigonglueEntity>();
		PageUtils page = discussyouxigonglueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyouxigonglue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussyouxigonglueEntity discussyouxigonglue){
       	EntityWrapper<DiscussyouxigonglueEntity> ew = new EntityWrapper<DiscussyouxigonglueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussyouxigonglue, "discussyouxigonglue")); 
        return R.ok().put("data", discussyouxigonglueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussyouxigonglueEntity discussyouxigonglue){
        EntityWrapper< DiscussyouxigonglueEntity> ew = new EntityWrapper< DiscussyouxigonglueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussyouxigonglue, "discussyouxigonglue")); 
		DiscussyouxigonglueView discussyouxigonglueView =  discussyouxigonglueService.selectView(ew);
		return R.ok("查询游戏攻略评论表成功").put("data", discussyouxigonglueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussyouxigonglueEntity discussyouxigonglue = discussyouxigonglueService.selectById(id);
        return R.ok().put("data", discussyouxigonglue);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussyouxigonglueEntity discussyouxigonglue = discussyouxigonglueService.selectById(id);
        return R.ok().put("data", discussyouxigonglue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussyouxigonglueEntity discussyouxigonglue, HttpServletRequest request){
    	discussyouxigonglue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        Long userId = (Long) request.getSession().getAttribute("userId");
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);
        Object role = request.getSession().getAttribute("role");
        if(!role.equals("用户")){
            return R.error();
        }
        if(yonghuEntity.getBanned() != 0){
            return R.error("你已经被禁言");
        }
        discussyouxigonglueService.insert(discussyouxigonglue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussyouxigonglueEntity discussyouxigonglue, HttpServletRequest request){
    	discussyouxigonglue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussyouxigonglue);

        discussyouxigonglueService.insert(discussyouxigonglue);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussyouxigonglueEntity discussyouxigonglue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyouxigonglue);
        discussyouxigonglueService.updateById(discussyouxigonglue);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussyouxigonglueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussyouxigonglueEntity> wrapper = new EntityWrapper<DiscussyouxigonglueEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussyouxigonglueService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
