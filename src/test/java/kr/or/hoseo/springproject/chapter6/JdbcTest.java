package kr.or.hoseo.springproject.chapter6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.hoseo.springproject.chapter6.config.AppConfig;
import kr.or.hoseo.springproject.chapter6.dao.MusicDao;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigWebContextLoader.class)
public class JdbcTest {

	@Autowired
	MusicDao musicDao;
	
	@Test
	public void test() {
		assertEquals(0, musicDao.getMusicCount());
	}

}
