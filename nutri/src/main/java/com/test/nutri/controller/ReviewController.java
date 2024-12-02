package com.test.nutri.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.nutri.entity.Review;
import com.test.nutri.entity.ReviewImage;
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
		
		// 사용자가 입력한 keyword 확인
		System.out.println(">>>>>>>>> keyword: " + keyword);
		
		// 총 리뷰 개수 조회
		int count = reviewQureyDSLRepository.count(keyword);
		
		// 페이지 당 리뷰 개수 및 최대 페이지 개수 
		double maxListSize = 15;								//페이지 당 보여줄 최대 리뷰 수
		double maxPageSize = 15;								//페이지 블록 당 최대 페이지 수
		int pageCount = (int) Math.ceil(count / maxListSize); 	//전체 페이지 수
		int offset = (int) ((page - 1) * maxListSize);			// 데이터 조회 시작 위치 계산

		// DB에서 리뷰 검색
		List<VwReview> list = reviewQureyDSLRepository.search(offset, (int) maxPageSize, keyword);
		
        // 페이징 처리
		StringBuilder sb = new StringBuilder();
		int firstPage = (int) (Math.floor((page - 1) / maxPageSize) * maxPageSize + 1); //현재 페이징 블록의 첫번째 페이지
		int beforePage = (int) (firstPage - maxPageSize);								//이전 페이징 블록
		int nextPage = (int) (firstPage + maxPageSize);									//다음 페이징 블록
	
		// 이전 블록이 0 이하인 경우 1로 설정
		if (beforePage < 0) {
	   	 	beforePage = 1;			
	   	}
	
		// 다음 블록이 전체 페이지 수를 초과하면 마지막 페이지로 설정
		if (nextPage > pageCount) {	
			nextPage = pageCount;	
		}
		
		// 이전 페이지 링크 추가
		if (page > 1) {
			if (keyword != null && !keyword.trim().isEmpty()) { // 검색 키워드가 있는 경우
			     sb.append(String.format("<a href=\"/review?page=%d&keyword=%s\">&lt;</a>", beforePage, keyword));
			} else { // 검색 키워드가 없는 경우
				 sb.append(String.format("<a href=\"/review?page=%d\">&lt;</a>", beforePage));
			}
		}
		
		// 현재 블록 페이지 링크 추가
		for (int i = firstPage; i <= pageCount && i < firstPage + maxPageSize; i++) {
			if (page == i) {
				sb.append(String.format("<a href=\"/review?page=%d\" class=\"active\">%d</a>", i, i));
			} else {
				sb.append(String.format("<a href=\"/review?page=%d\">%d</a>", i, i));
			}
		}
		
		// 다음 페이지 링크 추가
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
      
		return "page/viewReview";
	}
   
	
	@GetMapping("/addReview")
	public String getAddReview(Model model) {
		
		
		return "page/addReview";
	}
	
	@PostMapping("/addReview")
    public String postAddReview(Model model 
    							, @RequestParam("title") String title
    							, @RequestParam("category") String category
    							, @RequestParam("name") String name
    							, @RequestParam("content") String content
    							, @RequestParam(value = "image", required = false) MultipartFile image) {
		
//		String uploadDir = "src/main/resources/static/asset/place";
//		    
//	    File uploadDirPath = new File(uploadDir);
//	    if (!uploadDirPath.exists()) {
//	        uploadDirPath.mkdirs(); // 디렉토리가 없으면 생성
//	    }
//
//	    // 리뷰 저장
//	    Review review = new Review(title, category, name, content, null); // 이미지 경로는 null
//	    reviewQureyDSLRepository.save(review); // 저장 후 ID 생성
//
//	    // 이미지 저장
//	    if (images != null && !images.isEmpty()) {
//	        for (MultipartFile image : images) {
//	            try {
//	                String originalFileName = image.getOriginalFilename();
//	                String storedFileName = System.currentTimeMillis() + "_" + originalFileName;
//
//	                // 파일 저장
//	                File destinationFile = new File(uploadDirPath, storedFileName);
//	                image.transferTo(destinationFile);
//
//	                // 이미지 정보를 DB에 저장
//	                ReviewImage reviewImage = ReviewImage.builder()
//	                        .review_seq(review.getId()) // Review의 ID 연결
//	                        .image("/asset/place/" + storedFileName) // 상대 경로 저장
//	                        .build();
//	                reviewImageRepository.save(reviewImage);
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	                return "파일 저장 중 오류 발생";
//	            }
//	        }
//	    }
		

        return "redirect:/review"; 
    }
	
	
	@GetMapping("/editReview")
	public String getEditReview(Model model, @RequestParam(value = "seq") Long seq) {
       
	   // seq를 기준으로 해당 리뷰 조회 
	   VwReview vwreview = reviewQureyDSLRepository.findReviewBySeq(seq);
	    
	   if (vwreview == null) {
	   
		    System.out.println(">>>>>>>>> " + seq + "번째 리뷰를 찾을 수 없습니다.");
	        return "redirect:/review";
	    }
	   
	   model.addAttribute("review", vwreview);
	   
	   return "page/editReview";
	}
   
	@PostMapping("/editReview")
	public String postEditReview(Model model
									, @RequestParam("seq") Long seq
									, @RequestParam("category") String category
	    							, @RequestParam("name") String name
									, @RequestParam("title") String title
									, @RequestParam("content") String content) {
		
		try {
			//리뷰 수정 처리
			reviewQureyDSLRepository.updateReview(seq, category, name, title, content);
			System.out.println(">>>>>>>>> " + seq + "번째 리뷰가 성공적으로 수정되었습니다.");
			
			// 수정된 리뷰를 다시 조회하여 모델에 추가
	        VwReview updateReview = reviewQureyDSLRepository.findReviewBySeq(seq);
	        model.addAttribute("review", updateReview);
			
		} catch (Exception e) {
			
	        System.out.println(">>>>>>>>> " + seq + "번째 리뷰 수정 중 오류가 발생했습니다.");
	        e.printStackTrace();
	    }
		
		return "redirect:/viewReview?seq=" + seq;
	}
	
	@GetMapping("/delReview") 
	public String deleteReview(Model model, @RequestParam("seq") Long seq) {
		
		model.addAttribute("seq", seq);
		
		return "page/delReview";
	}
	
	@PostMapping("/delReview")
	public String deleteReview(@RequestParam("seq") Long seq) {
	   
		try {
	        // DB에서 해당 리뷰 삭제
	        reviewQureyDSLRepository.deleteReviewBySeq(seq);
	        System.out.println(">>>>>>>>> " + seq + "번째 리뷰가 성공적으로 삭제되었습니다.");
	        
	    } catch (Exception e) {
	    	
	    	System.out.println(">>>>>>>>> " + seq + "번째 리뷰 삭제 중 오류가 발생했습니다.");
	        e.printStackTrace();
	        
	    }
		
	    return "redirect:/review";
	
	}
      
}