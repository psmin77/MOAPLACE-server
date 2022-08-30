package com.moaplace.service;


import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moaplace.dto.admin.show.ShowListDTO;
import com.moaplace.mapper.ShowMapper;
import com.moaplace.util.ShowListPageUtil;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ShowServiceTest {

	@Autowired
  private ShowService service;
	
	@Autowired
	private ShowMapper mapper;
	
	@Test
	public void test() {
		
		HashMap<String, Object> sList = new HashMap<String, Object>();
		
		sList.put( "startRow", 1);
		sList.put( "endRow", 5);
		sList.put( "showCheck", "Y");
		sList.put( "field", "hall");
		sList.put( "search", "모던홀");
		
		List<ShowListDTO> list=mapper.showList(sList);
		log.info(list);
//		List<ShowVO> list=service.selectName();
//		log.info(list);
//		log.info(savePath);
	}

	
	@Test
	public void test1() {
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		
		int totalRowCount=service.count();
		ShowListPageUtil sp=new ShowListPageUtil(1,8, 5, totalRowCount);
		int startRow=sp.getStartRow();//시작행번호
		int endRow=sp.getEndRow();//끝행번호
		
//		log.info(startRow);
//		log.info(endRow);
		
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		if(service.list(map)!=null) {
			log.info("확인");
			log.info(service.list(map));
		}
//		List<showDTO> test=service.list();
//		for(showDTO dto : test) {
//			log.info(dto);
//		}
	}
	
	@Test
	public void test2() {
		if(service.count()>=0) {
			log.info("확인");
			log.info(service.count());
		}
	}
}
