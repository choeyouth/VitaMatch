package com.test.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.admin.board.BoardController;
import com.test.admin.dto.NoticeDTO;
import com.test.admin.service.NoticeService;

@Controller
@RequestMapping("/notice") 
public class NoticeController extends BoardController<NoticeDTO> {
	
	private final NoticeService service;

	public NoticeController(NoticeService service) {
		super(service, "notice");
        this.service = service;
	}
}
