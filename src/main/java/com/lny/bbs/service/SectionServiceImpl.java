package com.lny.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lny.bbs.dao.SectionMapper;
import com.lny.bbs.pojo.Section;
import com.lny.bbs.pojo.SectionVo;
import com.lny.bbs.pojo.pageQueryVo;

@Service
public class SectionServiceImpl implements SectionService {
	
	@Autowired
	private SectionMapper sectionMapper;
	
	public List<SectionVo> getAllSection() {
		return sectionMapper.selectAllSection();
	}
	public List<Section> getSectionPage(pageQueryVo pageQueryVo) {
		return sectionMapper.selectSectionPage(pageQueryVo);
	}
	public Integer getSectionCount() {
		return sectionMapper.querySectionCount();
	}
	public Integer changeSection(Section sectionForm) {
		return sectionMapper.updateSection(sectionForm);
	}
	public Section getSectionById(Integer id) {
		return sectionMapper.selectSectionById();
	}
	public Integer addSection(Section sectionForm) {
		return sectionMapper.insertSection(sectionForm);
	}
	public Integer removeSection(Section sectionForm) {
		return sectionMapper.deleteSection(sectionForm);
	}
	public Integer querySectionByName(String sec_name) {
		return sectionMapper.selectSectionByName(sec_name);
	}
	public Integer changeOldPosition(Integer uid) {
		return sectionMapper.updateOldPosition(uid);
	}
	public Section getSectionByUid(Integer uid) {
		return sectionMapper.selectSectionByUid(uid);
	}

}
