package kr.or.hoseo.springproject.chapter6.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.hoseo.springproject.chapter6.service.MusicService;
import kr.or.hoseo.springproject.chapter6.vo.Music;

@Controller
public class MusicController {
	@Autowired
	MusicService musicService;
	
	@RequestMapping("/")
	public String index(Model model) {
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", musicService.getAllMusics());
		return "list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		Music music = new Music();
		music.setUploadDttm(new Date());
		model.addAttribute("music", music);
		return "add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("music") Music music, BindingResult result) {
		musicService.addMusic(music);
		return "redirect:list";
	}

}
