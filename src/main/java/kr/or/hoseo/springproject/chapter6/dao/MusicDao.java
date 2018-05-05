package kr.or.hoseo.springproject.chapter6.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.hoseo.springproject.chapter6.vo.Music;

@Repository
public class MusicDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String INSERT_QUERY = "INSERT INTO musics(title,artist,uploaddttm,views,likes,unlikes,url,thumbnailpath) VALUES(?,?,?,?,?,?,?,?)";
	
	
	public List<Music> getAllMusics(){
		return jdbcTemplate.query("select * from musics", 
				new BeanPropertyRowMapper<>(Music.class));
	}
	public boolean addMusic(Music music){
		return jdbcTemplate.update(INSERT_QUERY,
				music.getTitle(),
				music.getArtist(),
				music.getUploadDttm(),
				music.getViews(),
				music.getLikes(),
				music.getUnlikes(),
				music.getUrl(),
				music.getThumbnailPath()) > 1 ? true : false;
	}
	
}