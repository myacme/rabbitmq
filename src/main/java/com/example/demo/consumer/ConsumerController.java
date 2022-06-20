package com.example.demo.consumer;


import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/6/20 9:51
 */
@RestController
public class ConsumerController {

	@Resource
	private Consumer consumer;

	public String receiveMessages(){
		return "";
	}
}