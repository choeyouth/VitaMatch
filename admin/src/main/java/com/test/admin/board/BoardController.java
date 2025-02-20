package com.test.admin.board;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.admin.util.PathHelper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/board") 
public abstract class BoardController<D extends BoardDTO> {

	private final BoardServiceImpl<? extends Board, D> service;
	private final String PATH;
	
//	목록
	@GetMapping
	public String getList(Model model, @RequestParam(name = "page", defaultValue = "1", required = false) int page) {
		int size = 10;
		
		model.addAttribute("list", service.getList(page, size));
		
		return PathHelper.getListPath(PATH);
	}
	
//	상세
	@GetMapping("/{seq}")
	public String getDetail(Model model, @PathVariable Long seq) {
		
		model.addAttribute("board", service.get(seq));
		
		return PathHelper.getDetailPath(PATH);
	}
	
//	글쓰기 화면
	@GetMapping("/write")
	public String getWriteView() {
		return PathHelper.getWritePath(PATH);
	}
	
//	수정 화면
	@GetMapping("/{seq}/edit")
	public String getEditView(Model model, @PathVariable Long seq) {
		
		model.addAttribute("board", service.get(seq));
		
		return PathHelper.getEditPath(PATH);
	}
	
//	글쓰기
	@PostMapping
	public String post(Model model, @ModelAttribute D dto) {
		
		D result = service.create(dto);

		return PathHelper.redirectDetailPath(PATH, result.getSeq());
	}
	
	
//	수정하기
	@PutMapping("/{seq}")
	public String put(Model model, @PathVariable Long seq, @ModelAttribute D dto) {
		
		dto.setSeq(seq);
		
		D result = service.update(dto);

		return PathHelper.redirectDetailPath(PATH, result.getSeq());
	}
	
	
//	삭제하기
	@DeleteMapping("/{seq}")
	public String delete(Model model, @PathVariable Long seq) {
		service.delete(seq);
		return PathHelper.redirectListPath(PATH);
	}
}
