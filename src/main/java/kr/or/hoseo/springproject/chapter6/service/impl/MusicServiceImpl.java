package kr.or.hoseo.springproject.chapter6.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.hoseo.springproject.chapter6.service.MusicService;
import kr.or.hoseo.springproject.chapter6.vo.Music;

@Service
public class MusicServiceImpl implements MusicService{

	@Override
	public List<Music> getAllMusics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMusic(Music music) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMusic(Music music) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMusic(Music music) {
		// TODO Auto-generated method stub
		return false;
	}
}
