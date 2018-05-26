package kr.or.hoseo.springproject.chapter6.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.hoseo.springproject.chapter6.service.MusicService;
import kr.or.hoseo.springproject.chapter6.view.ExcelView;
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
	public String list(Model model, HttpServletRequest req, Principal principal) {
		req.isUserInRole("ROLE_ADMIN");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		boolean authorized = authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		model.addAttribute("list", musicService.getAllMusics());
		
		return "list";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public List<Music> jsonList() {
		return musicService.getAllMusics();
	}
	
	
	@RequestMapping("/excel")
	public ModelAndView excelDownload() {
		Map<String,Object> model = new HashMap<>();
		model.put("list", musicService.getAllMusics());
		ModelAndView mv = new ModelAndView(new ExcelView(), model);
		return mv;
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
