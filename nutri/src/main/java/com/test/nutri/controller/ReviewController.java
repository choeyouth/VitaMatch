package com.test.nutri.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.nutri.entity.VwReview;
import com.test.nutri.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewController {

   private final ReviewRepository reviewRepository;
   
   @GetMapping("/review")
   public String review(Model model, @RequestParam(defaultValue = "1", name = "page") Integer page) {
      
      int count = reviewRepository.count();
      double maxListSize = 10;
      double maxPageSize = 10;
      int pageCount = (int) Math.ceil(count / maxListSize);
      int offset = (int) ((page - 1) * maxListSize);
      
      List<VwReview> list = reviewRepository.findAllPagenation(offset, 10);
      
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
      
      sb.append(String.format("<a href=\"/review?page=%d\">&lt;</a>", beforePage));
      
      for (int i = firstPage; i <= pageCount && i < firstPage + maxPageSize; i++) {
         if (page == i) {
            sb.append(String.format("<a href=\"/review?page=%d\" class=\"active\">%d</a>", i, i));
         } else {
            sb.append(String.format("<a href=\"/review?page=%d\">%d</a>", i, i));
         }
      }
      
      sb.append(String.format("<a href=\"/review?page=%d\">&gt;</a>", nextPage));
   
      
      model.addAttribute("list", list);
      model.addAttribute("page", sb.toString());
      
      return "page/review";
   }
   
   @GetMapping("/viewReview")
   public String viewReview(Model model, @RequestParam(value = "seq", required = false) Long seq) {
       
      if (seq == null) {
           return "redirect:/review";  
       }
       
      VwReview vwreview = reviewRepository.findReviewBySeq(seq);
      
      model.addAttribute("review", vwreview);
      
      return "page/viewreview";
   }
   
   @GetMapping("/addReview")
   public String addReview(Model model) {
      
      return "page/addReview";
   }
   
   @GetMapping("/editReview")
   public String editReview(Model model) {
      
      return "page/editReview";
   }
   
   @GetMapping("/delReview")
   public String deltReview(Model model) {
      
      return "page/delReview";
   }
      


}
