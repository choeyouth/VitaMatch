package com.test.nutri.controller;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.nutri.entity.VwReview;
import com.test.nutri.repository.ReviewQureyDSLRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewController {
	
	private final ReviewQureyDSLRepository reviewQureyDSLRepository;
   
	@GetMapping("/review")
	public String review(Model model 
							, @RequestParam(name = "keyword", required = false) String keyword
		   					, @RequestParam(defaultValue = "1", name = "page") Integer page) {
		
		System.out.println(">>>>>>>>>" + keyword);
		
		int count = reviewQureyDSLRepository.count(keyword);
		double maxListSize = 15;
		double maxPageSize = 15;
		int pageCount = (int) Math.ceil(count / maxListSize);
		int offset = (int) ((page - 1) * maxListSize);

		List<VwReview> list = reviewQureyDSLRepository.search(offset, (int) maxPageSize, keyword);
		
        //페이징
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
		
		if (page > 1) {
			if (keyword != null && !keyword.trim().isEmpty()) {
			     sb.append(String.format("<a href=\"/review?page=%d&keyword=%s\">&lt;</a>", beforePage, keyword));
			} else {
				 sb.append(String.format("<a href=\"/review?page=%d\">&lt;</a>", beforePage));
			}
		}
		
		for (int i = firstPage; i <= pageCount && i < firstPage + maxPageSize; i++) {
			if (page == i) {
				sb.append(String.format("<a href=\"/review?page=%d\" class=\"active\">%d</a>", i, i));
			} else {
				sb.append(String.format("<a href=\"/review?page=%d\">%d</a>", i, i));
			}
		}
		
		if (page < pageCount) { 
			if (keyword != null && !keyword.trim().isEmpty()) {
				sb.append(String.format("<a href=\"/review?page=%d&keyword=%s\">&gt;</a>", nextPage, keyword));
			} else {
				sb.append(String.format("<a href=\"/review?page=%d\">&gt;</a>", nextPage));
			}
		}

	    model.addAttribute("list", list);
	    model.addAttribute("page", sb.toString());
	    
	    return "page/review";
	}
   
	@GetMapping("/viewReview")
	public String viewReview(Model model, @RequestParam(value = "seq", required = false) Long seq) {
       
		if (seq == null) {
			return "redirect:/review";  
		}
       
		VwReview vwreview = reviewQureyDSLRepository.findReviewBySeq(seq);
      
		model.addAttribute("review", vwreview);
      
		return "page/viewreview";
	}
   
	/*
	@GetMapping("/addReview")
	public String addReview(Model model) {
      
		return "page/addReview";
	}
	*/
	
	@GetMapping("/addReview")
	public String addReview(Model model) {
		return "page/addReview";
	}
	
	
	@PostMapping("/addReview")
    public String addReview(Model model 
    							, @RequestParam(value = "title", required = false) String title
    							, @RequestParam(value = "category", required = false) String category
    							,@RequestParam(value = "name", required = false) String name
    							, @RequestParam(value = "content", required = false) String content
    							, @RequestParam(value = "image") MultipartFile image) {
        /* 여기 다 수정해야 됨 */
		try {
            // 파일 저장 경로
            String uploadDir = "C:/upload"; // 원하는 경로로 변경
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            // 파일 저장
            if (!image.isEmpty()) {
                String fileName = image.getOriginalFilename();
                File file = new File(dir, fileName);
                image.transferTo(file);
                model.addAttribute("imagePath", "/upload/" + fileName);
            }

            System.out.println("제목: " + title);
            System.out.println("카테고리: " + category);
            System.out.println("제품명: " + name);
            System.out.println("내용: " + content);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "파일 업로드 실패");
        }

        return "redirect:/review"; 
    }
	
   
	@GetMapping("/editReview")
	public String editReview(Model model) {
      
		return "page/editReview";
	}
   
	@GetMapping("/delReview") 
	public String deleteReview(Model model) {
		
		return "page/delReview";
	}
	
	@PostMapping("/delView")
	public String deleteReview(Model model, @RequestParam("seq") Long seq) {
	   
		try {
	        // DB에서 해당 리뷰 삭제
	        reviewQureyDSLRepository.deleteReviewBySeq(seq);
	        model.addAttribute("message", "리뷰가 성공적으로 삭제되었습니다.");
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("error", "리뷰 삭제 중 오류가 발생했습니다.");
	    }
		
	    return "redirect:/review"; 
	
	}
      
}