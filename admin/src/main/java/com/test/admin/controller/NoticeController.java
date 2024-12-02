package com.test.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.admin.dto.NoticeDTO;
import com.test.admin.service.NoticeService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class NoticeController {

	private final NoticeService noticeService;
	
	@GetMapping("/notice")
	public String getNotice(Model model, @RequestParam(value = "seq") Long seq, @RequestParam(defaultValue = "1", name = "page") Integer page) {
		if (seq != null) {
			
			NoticeDTO notice = noticeService.get(seq);
			
			model.addAttribute("notice", notice);
			
			return "page/noticeDetail";
		} else {
			int count = noticeService.getCount();
			double maxListSize = 6;
			double maxPageSize = 10;
			int pageCount = (int) Math.ceil(count / maxListSize);
			int offset = (int) ((page - 1) * maxListSize);

			List<NoticeDTO> list = noticeService.getNoticeList(offset, (int) maxListSize);

			StringBuilder sb = new StringBuilder();

			int firstPage = (int) (Math.floor((page - 1) / maxPageSize) * maxPageSize + 1);
			int beforePage = (int) (firstPage - maxPageSize);
			int nextPage = (int) (firstPage + maxPageSize);

			if (beforePage < 0) {
				beforePage = 1;
			}

			if (nextPage > pageCount) {
				nextPage = pageCount;
			}

			sb.append(String.format("<a href=\"/notice?page=%d\">&lt;</a>", beforePage));

			for (int i = firstPage; i <= pageCount && i < firstPage + maxPageSize; i++) {
				if (page == i) {
					sb.append(String.format("<a href=\"/notice?page=%d\" class=\"active\">%d</a>", i, i));
				} else {
					sb.append(String.format("<a href=\"/notice?page=%d\">%d</a>", i, i));
				}
			}
			
			sb.append(String.format("<a href=\"/notice?page=%d\">&gt;</a>", nextPage));

			model.addAttribute("list", list);
			model.addAttribute("page", sb.toString());
			
			return "page/notice";
		}
	}
	
}
