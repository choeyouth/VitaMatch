package com.test.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.admin.dto.NoticeDTO;
import com.test.admin.repository.NoticeQueryDSLRepository;
import com.test.admin.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeService {
	
	private final NoticeRepository noticeRepository;
	
	private final NoticeQueryDSLRepository noticeQueryDSLRepository;

	public int getCount() {
		return (int) noticeRepository.count();
	}

	public List<NoticeDTO> getNoticeList(int offset, int limit) {
		return noticeQueryDSLRepository.findAllPagenation(offset, limit)
				.stream().map(notice -> notice.toDTO()).toList();
	}

	public NoticeDTO get(Long seq) {
		return noticeRepository.findById(seq).get().toDTO();
	}

}
