package com.lny.bbs.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lny.bbs.pojo.PageBean;
import com.lny.bbs.pojo.Section;
import com.lny.bbs.pojo.SectionVo;
import com.lny.bbs.pojo.pageQueryVo;
import com.lny.bbs.service.SectionService;

@Controller
public class SectionController {
	@Autowired
	private SectionService sectionService;
	
	@RequestMapping(value="/AllSection/get",method= {RequestMethod.GET})
	public @ResponseBody List<SectionVo> section() throws IllegalStateException, IOException {
		return sectionService.getAllSection();
	}
	@RequestMapping(value="/sectionPage/get",method= {RequestMethod.GET})
	public @ResponseBody PageBean<Section> sectionPage(Integer currentPage) throws IllegalStateException, IOException {
		PageBean<Section> pageBean = new PageBean<Section>();
		pageBean.setTotalCount(sectionService.getSectionCount());
//		pageBean.setCurrentPage(currentPage);
		pageQueryVo pageQueryVo = new pageQueryVo();
		pageQueryVo.setStartIndex((currentPage-1)*pageBean.getPageSize());
		pageQueryVo.setPageSize(pageBean.getPageSize());
		pageBean.setPageData(sectionService.getSectionPage(pageQueryVo));
		return pageBean;
	}
	@RequestMapping(value="/sectionChange/post",method= {RequestMethod.POST})
	public @ResponseBody Integer changeSectionPage(Section sectionForm) throws IllegalStateException, IOException {
		return sectionService.changeSection(sectionForm);
	}
	@RequestMapping(value="/addSection/post",method= {RequestMethod.POST})
	public @ResponseBody Integer addSectionPage(Section sectionForm) throws IllegalStateException, IOException {
		return sectionService.addSection(sectionForm);
	}
	@RequestMapping(value="/deleteSection/post",method= {RequestMethod.POST})
	public @ResponseBody Integer removeSectionPage(Section sectionForm) throws IllegalStateException, IOException {
		return sectionService.removeSection(sectionForm);
	}
}
