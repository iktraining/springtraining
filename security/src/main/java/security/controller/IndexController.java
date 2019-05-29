package security.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import security.domain.RegistedUser;
import security.service.mapper.UserDaoMapper;

//Mapperを自動検出
@MapperScan("security.service.mapper")
//Controller Classとして設定
@Controller
public class IndexController {
	@Autowired
	private UserDaoMapper userDaoMapper;

	@RequestMapping(path="/index", method=RequestMethod.GET)
	public String showIndex(Model model) {
		List<RegistedUser> registedUsers = userDaoMapper.findAll();
		model.addAttribute("sampleUsers", registedUsers);
		model.addAttribute("message", "Hello Thymeleaf!");
		return "index";
	}

	@RequestMapping(path="/user", method=RequestMethod.GET)
	public String showUser(Model model) {
		model.addAttribute("message", "Hello User!");
		return "user";
	}

	@RequestMapping(path="/admin", method=RequestMethod.GET)
	public String showAdmin(Model model) {
		model.addAttribute("message", "Hello Admin!");
		return "admin";
	}
}
