package kr.or.hoseo.springproject.chapter6.vo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Music implements Serializable{
	@Max(20)
	@Min(1)
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
