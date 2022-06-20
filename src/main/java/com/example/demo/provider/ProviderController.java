package com.example.demo.provider;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/6/20 9:56
 */
@RestController
public class ProviderController {

	@Resource
	private Provider provider;


	@GetMapping("/send")
	public String send(){
		provider.send();
		return "success";
	}
}