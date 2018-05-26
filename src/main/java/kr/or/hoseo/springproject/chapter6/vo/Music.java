package kr.or.hoseo.springproject.chapter6.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Music {
	@NotEmpty
	private String title;
	@NotEmpty
	private String artist;
	private Date uploadDttm;
	private int views;
	private int likes;
	private int unlikes;
	@URL
	private String url;
	private String thumbnail;
	private String thumbnailPath;
}
