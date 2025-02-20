package com.test.admin.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.admin.dto.NoticeDTO;

@SpringBootTest
public class NoticeServiceTest {

	@Autowired
	private NoticeService service;

	@Test
	public void testCreate() {
		
		long before = service.count();
		
		getDummyData().stream().forEach((dto) -> {
			service.create(dto);
		});
		
		long after = service.count();
		
		assertEquals(15, after - before);
	}

	private List<NoticeDTO> getDummyData() {
		
		List<NoticeDTO> result = new ArrayList<NoticeDTO>();
		
		String str = "비타매치 오픈 안내 🎉\n개인 맞춤 영양제 추천 서비스, 지금 바로 시작해보세요! 건강 상태와 생활 습관을 분석하여 최적의 영양제를 추천해 드립니다.\n영양제 데이터 업데이트 🔄\n최신 건강 트렌드를 반영하여 새로운 영양제 정보를 추가했습니다. 나에게 딱 맞는 제품을 찾아보세요!\n건강 설문 기능 개선 📝\n더 정밀한 맞춤 추천을 위해 설문 항목이 업데이트되었습니다. 이전보다 더 정확한 결과를 확인해 보세요.\nAI 상담 서비스 베타 테스트 진행 중 🤖\nAI 챗봇을 통해 간편하게 영양제 상담을 받아보세요. 전문가 상담이 부담스러웠다면, AI와 빠르게 해결할 수 있습니다!\n이벤트 안내: 첫 추천 받기 무료! 🎁\n지금 가입하시면 맞춤 영양제 추천을 무료로 받아볼 수 있습니다. 내 몸에 꼭 맞는 영양제를 지금 확인해 보세요.\n영양제 성분 궁합 분석 기능 추가 🔬\n어떤 성분이 함께 먹으면 효과적인지, 피해야 할 조합은 무엇인지 확인할 수 있습니다. 보다 안전한 영양제 섭취를 위해 활용해 보세요.\n모바일 최적화 완료 📱\n스마트폰에서도 더욱 편리하게 이용할 수 있도록 모바일 UI를 개선했습니다. 언제 어디서든 쉽게 건강을 관리하세요!\n추천 시스템 성능 개선 ⚙️\n더 빠르고 정확한 추천을 위해 알고리즘을 개선했습니다. 이전보다 최적의 영양제를 더 신속하게 추천받을 수 있습니다.\n회원가입 시 건강 뉴스 알림 제공 📰\n건강 관련 최신 소식을 받아볼 수 있는 기능이 추가되었습니다. 영양제뿐만 아니라 건강 관리 정보까지 놓치지 마세요!\n내 주변 약국 찾기 기능 추가 🏥\n이제 가까운 약국을 쉽고 빠르게 검색할 수 있습니다. 추천받은 영양제를 오프라인에서도 편리하게 구매해 보세요.\n비타매치와 함께하는 건강 관리 가이드 📖\n올바른 영양제 섭취 방법과 건강 팁을 제공합니다. 꾸준한 건강 관리로 더 나은 생활 습관을 만들어 보세요.\n고객센터 운영 시간 안내 ⏰\n문의사항이 있으신가요? 평일 오전 9시부터 오후 6시까지 고객센터에서 상담을 도와드립니다. 편하게 문의해 주세요!\n1:1 맞춤 상담 서비스 준비 중 👨‍⚕️\n전문가 상담 기능이 곧 추가될 예정입니다. 내 몸 상태에 대한 더 정확한 상담을 받아보세요!\n추천 내역 저장 기능 추가 💾\n내가 받은 영양제 추천을 저장하고 언제든 다시 확인할 수 있습니다. 비교해 보면서 가장 적합한 영양제를 선택하세요.\n사이트 이용 만족도 조사 참여 이벤트 📝\n비타매치를 이용해 보신 후 의견을 남겨주세요! 설문에 참여해 주신 분들께 소정의 혜택을 드립니다.";

		String[] temp = str.split("\n");
		
		for(int i=0; i<temp.length; i+=2) {
			Random random = new Random();
			
			NoticeDTO dto = NoticeDTO.builder()
					.title(temp[i])
					.content(temp[i + 1])
					.regDate(LocalDateTime.now())
					.adminSeq(random.nextLong(10) + 1)
					.build();
			
			result.add(dto);
		}
		
		return result;
		
	}
}
