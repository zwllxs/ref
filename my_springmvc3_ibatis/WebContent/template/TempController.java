package com.wei.ssi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.wei.ssi.bean.${className};
import com.wei.ssi.model.${className}Model;
import com.wei.ssi.model.EmployeModel;
import com.wei.ssi.service.${className}Service;
import com.wei.ssi.utils.MethodUtil;
 
@Controller
public class ${className}Controller extends MultiActionController{
	
	private final static Logger log= Logger.getLogger(${className}Controller.class);
	
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private ${className}Service<${className}> ${lowerName}Service; 
	
	// Feild start
	private List<${className}> ${lowerName}List = null;
	private ${className} ${lowerName} = new ${className}();

	
	/**
	 * 
	 * <br>
	 * <b>功能：</b>${codeName}列表页面<br>
	 * <b>作者：</b>罗泽军<br>
	 * <b>日期：</b> Dec 8, 2011 <br>
	 * @return
	 */
	@RequestMapping("/${lowerName}/list") 
	public ModelAndView list(${className}Model model){
		Map<String,Object> map =new HashMap<String,Object>();
		try{
			${lowerName}List = ${lowerName}Service.selectByModel(model);
			map.put("model",model);
			map.put("resultList",${lowerName}List);
		}catch(Exception e){
			log.error(e);
			return new ModelAndView("error"); //访问WEB-INF/jsp/error.jsp
		}
		return new ModelAndView("${lowerName}/${lowerName}List",map); //访问WEB-INF/jsp/${lowerName}/${lowerName}List.jsp
	}


	/**
	 * 
	 * <br>
	 * <b>功能：</b>${codeName}到添加${codeName}信息页面<br>
	 * <b>作者：</b>罗泽军<br>
	 * <b>日期：</b> Dec 8, 2011 <br>
	 * @return
	 */
	@RequestMapping("/${lowerName}/toadd") 
	public ModelAndView toadd(${className} bean){
		return new ModelAndView("${lowerName}/${lowerName}Edit"); //访问WEB-INF/jsp/${lowerName}/${lowerName}Edit.jsp
	}
	
	
	/**
	 * 
	 * <br>
	 * <b>功能：</b>${codeName}到编辑${codeName}信息页面<br>
	 * <b>作者：</b>罗泽军<br>
	 * <b>日期：</b> Dec 8, 2011 <br>
	 * @param ids 确保前提只能转成一个主键编号过来
	 * @return
	 */
	@RequestMapping("/${lowerName}/toedit") 
	public ModelAndView toedit(Long ids){
		Map<String,Object> map =new HashMap<String,Object>();
		try{
			${lowerName} = ${lowerName}Service.selectById(ids);	
			//如果记录为空则跳转到错误页面
			if(${lowerName} == null){
				return new ModelAndView("error"); //访问WEB-INF/jsp/error.jsp
			}
			map.put("bean", ${lowerName});
		}catch(Exception e){
			log.error(e);
			return new ModelAndView("error"); //访问WEB-INF/jsp/error.jsp
		}
		return new ModelAndView("${lowerName}/${lowerName}Edit",map); //访问WEB-INF/jsp/${lowerName}/${lowerName}Edit.jsp
	}
	
	
	

	/**
	 * 
	 * <br>
	 * <b>功能：</b>保存${codeName}信息<br>
	 * <b>作者：</b>罗泽军<br>
	 * <b>日期：</b> Dec 8, 2011 <br>
	 * @return
	 */
	@RequestMapping("/${lowerName}/save") 
	public ModelAndView save(${className} bean){
		try{
			//判断Id主键是否为空，如果主键不叫Id，请改成你的主键属性名称
			if(bean.getId() != null && bean.getId()> 0){
				//id不为空修改
				${lowerName}Service.updateBySelective(bean);
			}else{
				//设置主键
				bean.setId(MethodUtil.getInit().getLongId());
				//id为空新增
				${lowerName}Service.insert(bean);
			}
		}catch(Exception e){
			log.error(e);
			return new ModelAndView("error"); //访问WEB-INF/jsp/error.jsp
		}
		return  list(new ${className}Model());//调整到list页面
	}
	
	/**
	 * 
	 * <br>
	 * <b>功能：</b>删除${codeName}信息<br>
	 * <b>作者：</b>罗泽军<br>
	 * <b>日期：</b> Dec 8, 2011 <br>
	 * @return
	 */
	@RequestMapping("/employe/deletes") 
	public ModelAndView deletes(Long[] ids){
		try{
			employeService.delete(ids);
		}catch(Exception e){
			log.error(e);
			return new ModelAndView("error"); //访问WEB-INF/jsp/error.jsp
		}
		return  list(new EmployeModel());//调整到list页面
	}

}
