package com.moaplace.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.moaplace.dto.RentalCalendarDTO;
import com.moaplace.dto.RentalListDTO;
import com.moaplace.dto.MyRentalDTO;
import com.moaplace.dto.MyRentalDetailDTO;
import com.moaplace.mapper.RentalMapper;

@Service
public class RentalService {

	@Autowired private RentalMapper mapper;
	
	// member_num으로 회원의 대관내역 존재여부 확인
	public boolean rentalExist(int member_num) {
		boolean exist = false;
		if(mapper.rentalExist(member_num) > 0) {
			exist = true;
		}
		return exist;
	}
	
	// member_num으로 회원의 가장 최근 대관내역 1건 조회
	public MyRentalDTO recentRental(int member_num) {
		return mapper.recentRental(member_num);
	}
	
	// member_num + startdate + enddate + startrow + endrow 받아서 기간설정 + 페이징 조회
	public List<MyRentalDTO> list(HashMap<String, Object> map) {
		return mapper.list(map);
	}
	
	// 기간설정  + 페이징 조회된 내역 개수
	public int listCount(HashMap<String, Object> map) {
		return mapper.listCount(map);
	}
	
	// rental_num으로 대관상세내역 조회
	public MyRentalDetailDTO detail(int rental_num) {
		return mapper.detail(rental_num);
	};
  
	public int insert(RentalVO vo) {
		return mapper.insert(vo);
	}
	
	public int getCount(HashMap<String, Object> map) {
		return mapper.getCount(map);
	}
	
	public List<RentalVO> list (HashMap<String, Object> map){
		return mapper.list(map);
	}
	
	public int updateState (HashMap<String, Object> map) {
		return mapper.updateState(map);
	}
	
	public List<RentalCalendarDTO> getSchedules(HashMap<String, String> map){
		return mapper.getSchedules(map);
	}
	
	public RentalVO detail(int rental_num) {
		return mapper.detail(rental_num);
	}

}
