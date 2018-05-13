package kr.or.hoseo.springproject.chapter6.vo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Music implements Serializable{
	@Size(min=1, max=20)
	private String title;
	
	@NotEmpty
	private String artist;
	private Date uploadDttm;
	private int views;
	private int likes;
	private int unlikes;
	@URL
	private String url;
	private String thumbnailPath;
}
