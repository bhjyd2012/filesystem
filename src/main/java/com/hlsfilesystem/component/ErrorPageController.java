package com.hlsfilesystem.component;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController {
		@RequestMapping("401")
		public String get401page() {
			return "errorpage/401";
		}
	  @RequestMapping("403")
		public String get403page() {
			return "errorpage/403";
		}
	  @RequestMapping("404")
		public String get404page() {
			return "errorpage/404";
		}
	  @RequestMapping("500")
		public String get500page() {
			return "errorpage/500";
		}
}
