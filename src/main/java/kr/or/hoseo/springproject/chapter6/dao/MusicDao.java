package kr.or.hoseo.springproject.chapter6.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.hoseo.springproject.chapter6.vo.Music;

@Repository
public interface MusicDao {
	public List<Music> getAllMusics();
	public int insertMusic(Music music);
	public int getMusicCount();
}
