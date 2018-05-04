package kr.or.hoseo.springproject.chapter6.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Music {
	private String title;
	private String artist;
	private Date uploadDttm;
	private int views;
	private int likes;
	private int unlikes;
	private String url;
	private MultipartFile thumbnail;
	private String thumbnailPath;
}
