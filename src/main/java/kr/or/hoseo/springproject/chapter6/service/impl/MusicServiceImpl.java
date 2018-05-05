package kr.or.hoseo.springproject.chapter6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.hoseo.springproject.chapter6.dao.MusicDao;
import kr.or.hoseo.springproject.chapter6.service.MusicService;
import kr.or.hoseo.springproject.chapter6.vo.Music;

@Service
public class MusicServiceImpl implements MusicService{

	@Autowired
	MusicDao musicDao;
	
	@Override
	public List<Music> getAllMusics() {
		return musicDao.getAllMusics();
	}

	@Override
	public boolean addMusic(Music music) {
		return musicDao.insertMusic(music) > 0 ? true : false;
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
