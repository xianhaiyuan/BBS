package com.lny.bbs.service;

import java.util.List;

import com.lny.bbs.pojo.Section;
import com.lny.bbs.pojo.SectionVo;
import com.lny.bbs.pojo.pageQueryVo;

public interface SectionService {

	List<SectionVo> getAllSection();

	List<Section> getSectionPage(pageQueryVo pageQueryVo);
	Integer getSectionCount();

	Integer changeSection(Section sectionForm);

	Section getSectionById(Integer id);

	Integer addSection(Section sectionForm);

	Integer removeSection(Section sectionForm);
	
	Integer querySectionByName(String sec_name);
	
	Integer changeOldPosition(Integer uid);

}
