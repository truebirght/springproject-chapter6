package kr.or.hoseo.springproject.chapter6.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.hoseo.springproject.chapter6.vo.Music;

@Repository
public class MusicDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Music> getAllMusics(){
		//TODO :: 구현해야함
		return null;
	}
}
