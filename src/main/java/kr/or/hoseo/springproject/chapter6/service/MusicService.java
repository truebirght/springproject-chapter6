package kr.or.hoseo.springproject.chapter6.service;

import java.util.List;

import kr.or.hoseo.springproject.chapter6.vo.Music;

public interface MusicService {
	public List<Music> getAllMusics();
	public boolean addMusic(Music music);
	public boolean deleteMusic(Music music);
	public boolean updateMusic(Music music);
	public Music getMusicDetail(String title);
	
}
