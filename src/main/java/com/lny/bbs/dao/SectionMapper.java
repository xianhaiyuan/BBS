package com.lny.bbs.dao;

import java.util.List;

import com.lny.bbs.pojo.Section;
import com.lny.bbs.pojo.SectionVo;
import com.lny.bbs.pojo.pageQueryVo;

public interface SectionMapper {

	List<SectionVo> selectAllSection();

	List<Section> selectSectionPage(pageQueryVo pageQueryVo);

	Integer querySectionCount();

	Integer updateSection(Section sectionForm);

	Section selectSectionById();

	Integer insertSection(Section sectionForm);

	Integer deleteSection(Section sectionForm);


}
