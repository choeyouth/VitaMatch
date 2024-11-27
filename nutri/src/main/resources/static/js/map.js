 
$('document').ready(function() {
	var area0 = ["시/도 선택","서울특별시","인천광역시","대전광역시","광주광역시","대구광역시","울산광역시","부산광역시","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주도"];
	var area1 = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
	var area2 = ["계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
	var area3 = ["대덕구","동구","서구","유성구","중구"];
	var area4 = ["광산구","남구","동구",     "북구","서구"];
	var area5 = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"];
	var area6 = ["남구","동구","북구","중구","울주군"];
	var area7 = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
	var area8 = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
	var area9 = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
	var area10 = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
	var area11 = ["계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
	var area12 = ["군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
	var area13 = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
	var area14 = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
	var area15 = ["거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
	var area16 = ["서귀포시","제주시","남제주군","북제주군"];

	// 시/도 선택 박스 초기화
	$("select[name^=sido]").each(function() {
		$selsido = $(this);
		$.each(eval(area0), function() {
			$selsido.append("<option value='"+this+"'>"+this+"</option>");
		});
		$selsido.next().append("<option value=''>구/군 선택</option>");
	});
	
	 // 시/도 선택시 구/군 설정
	$("select[name^=sido]").change(function() {
		
		var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 구군 Array
		var $gugun = $(this).next(); // 선택영역 군구 객체
		$("option",$gugun).remove(); // 구군 초기화

		if(area == "area0")  $gugun.append("<option value=''>구/군 선택</option>");
		else {
			$.each(eval(area), function() {
				$gugun.append("<option value='"+this+"'>"+this+"</option>");
			});
		}
	});
}); 

	
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
		level: 3 // 지도의 확대 레벨
	};  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();  

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

// 키워드 검색을 요청하는 함수입니다
function searchPlaces(i) {
	
	var keyword = document.getElementById('keyword').value.trim();
	const sido = $('#sido1').val(); 
	const gugun = $('#gugun1').val(); 
	let page; // let으로 선언하여 값을 재할당 가능

	if (i == null) {
		page = 1; // i가 null이면 첫 페이지
	} else {
		page = i; // i가 주어지면 해당 페이지
	}
	
	if (!sido || !gugun) {
		alert('시/도와 구/군을 모두 선택해주세요.');
		return;
	}
	
	if (!keyword.replace(/^\s+|\s+$/g, '')) {
		alert('키워드를 입력해주세요!');
		return false;
	}

	//ps.keywordSearch( keyword, placesSearchCB); 
	
	getPharmacy(keyword, sido, gugun, page);
	
}


function getPharmacy(keyword, sido, gugun, page) {
	
	//setTimeout(function(){
	$.ajax({
		url: '/pharmacy/list', 
		type: 'GET',
		data: {
			sido: sido,
			gugun: gugun,
			page: page,
			keyword: keyword 
		},
		dataType: 'json', 
		success: function (result) {
		    const totalPages = Math.ceil(result.length / 10); // 한 페이지에 10개 기준
			displayPharmacies(result, page, totalPages);
			closePopup();
		},
		error: function (a,b,c) {
			console.error(a,b,c); 
		}
	});
	//}, 100); 
}

function displayPharmacies(pharmacies, currentPage, totalPages) {
    const placesList = document.getElementById('placesList');
    const paginationEl = document.getElementById('pagination');

    // 기존 리스트 초기화
    removeAllChildNods(placesList);

    if (pharmacies && pharmacies.length > 0) {
		const itemsPerPage = 10;
		const startIdx = (currentPage - 1) * itemsPerPage; // 시작 인덱스
		const endIdx = startIdx + itemsPerPage; // 종료 인덱스
		const currentData = pharmacies.slice(startIdx, endIdx);

		// 잘라낸 데이터로 리스트 생성
		currentData.forEach((pharmacy, index) => {
			const listItem = getListItem(index + startIdx, pharmacy); // 절대 인덱스 사용
			placesList.appendChild(listItem);
		});


    } else {
        // 데이터가 없는 경우 처리
        const li = document.createElement('li');
        li.textContent = "약국 데이터가 없습니다.";
        placesList.appendChild(li);
    }

	// 페이지네이션 처리
	displayPagination(pharmacies, totalPages, currentPage); 

	// 지도에 마커 표시
	displayMarkers(pharmacies);
}

// 약국 데이터로 리스트 아이템 생성
function getListItem(index, pharmacy) {
    const el = document.createElement('li');
	const isOpen = pharmacy.open ? 'open-phar' : 'close-phar';

	console.log(isOpen);

    let itemStr = `
        <span class="markerbg marker_${index + 1}"></span>
        <div class="map-info-head">
            <h5>${pharmacy.name}</h5>
    `;

    if (pharmacy.address) {
        itemStr += `
            <span>${pharmacy.address}</span>
            <div class="map-info">
                <div class="pharmacy-time">
                    <span class="${isOpen}">⦁&nbsp;&nbsp;&nbsp;</span>
                    <span class="${isOpen}">${pharmacy.open ? '영업중' : '영업 종료'}&nbsp;&nbsp;&nbsp;</span>
                    (${pharmacy.openTime} ~ ${pharmacy.closeTime})
                </div>
                <input type="hidden" value="${pharmacy.etc}" id="etc">
            </div>
        `;
    } else {
        itemStr += `<span>주소 정보 없음</span>`;
    }

    itemStr += `
            <span class="tel">${pharmacy.tel || '전화번호 없음'}</span>
        </div>
        <a class="more d-flex align-items-center float-start map-info-button" data-hpid="${pharmacy.hpid}">
            <span class="label">상세 보기</span>
            <span class="icon-keyboard_arrow_right"></span>
        </a>
    `;

    el.innerHTML = itemStr;
    el.className = 'item';

    return el;
}

document.querySelector('#placesList').addEventListener('click', (event) => {

	const listItem = event.target.closest('li');
	var etc = listItem.querySelector('#etc').value;

	if (!listItem) {
		console.log('리스트 항목이 클릭되지 않았습니다.');
		return;
	}

	const target = listItem.querySelector('a[data-hpid]');

	if (target) {

		const hpid = target.getAttribute('data-hpid');
		getPharmacyInfo(hpid, etc);

		// 상세보기 팝업 표시
		const popup = document.querySelector('.detail-popup');
		popup.style.display = 'block';
		
	} else {
		console.log('data-hpid 속성을 가진 요소를 찾을 수 없습니다.');
	}
	
});

function getPharmacyInfo(hpid, etc) {
	//setTimeout(function(){
	$.ajax({
		url: '/pharmacy/info',
		type: 'GET',
		data: { hpid: hpid },
		dataType: 'json',
		success: function (result) {
			if (Array.isArray(result) && result.length > 0) {
                showPharmacyInfo(result, etc); // 배열의 첫 번째 요소 전달
            } else {
                console.error("약국 데이터를 찾을 수 없습니다.");
            }
		},
	});
	//}, 100); 
}


function showPharmacyInfo(result, etc) {

	const popup = document.querySelector('.detail-popup'); 
    const pharmacy = result[0];

	const isOpen = pharmacy.open ? 'open-phar' : 'close-phar';
	
    if (!pharmacy) {
        console.error("유효한 약국 데이터가 없습니다.");
        return;
    }

	const str = `
		<div class="map-detail-title">
			<h2>약국 상세</h2>
			<button class="close-popup"></button>
		</div>
		<hr>
		<div class="pharmacy-detail-info">
			<h2>${pharmacy.name}</h2>	
			<div class="map-info">
				<div class="pharmacy-time"><span class="${isOpen}">⦁&nbsp;&nbsp;&nbsp;</span><span id="isOpen" class="${isOpen}">${pharmacy.open ? '영업중' : '영업 종료'}&nbsp;&nbsp;&nbsp;</span>(${pharmacy.openTime} ~ ${pharmacy.closeTime})</div>		
				<div>${pharmacy.address}</div>
				<div><span>전화번호 </span>${pharmacy.tel}</div>				
			</div>
			<div class="week-time">
				<table>
					<h3>평일 운영시간</h3>
					<tr>
						<th>평일</th>
						<td>${pharmacy.openTime} ~ ${pharmacy.closeTime}</td>								
					</tr>
				</table>
				<table>
					<h3>토요일 운영시간</h3>
					<tr>
						<th>매주</th>
						<td>${pharmacy.dutyTime6s == '정기 휴무' ? '정기 휴무' : `${pharmacy.dutyTime6s} ~ ${pharmacy.dutyTime6c}`}</td>								
					</tr>
				</table>
				<table>
					<h3>일요일 운영시간</h3>
					<tr>
						<th>일요일</th>
						<td>${pharmacy.dutyTime7s == '정기 휴무' ? '정기 휴무' : `${pharmacy.dutyTime7s} ~ ${pharmacy.dutyTime7c}`}</td>								
					</tr>
				</table>
				<div class="phar-otherInfo">
					<h3>공휴일 운영시간</h3>
					<div id="holiday-time">${pharmacy.dutyTime8s == '정기 휴무' ? '정기 휴무' : `${pharmacy.dutyTime8s} ~ ${pharmacy.dutyTime8c}`}</div>
					<h3>비고</h3>
					<div id="other-time">${etc}</div>
				</div>
			</div>
		</div> 
	`;
	
	popup.innerHTML = str;

	//마커 이동 
	var centerPosition = new kakao.maps.LatLng(pharmacy.latitude, pharmacy.longitude);
	map.setCenter(centerPosition);
	map.setLevel(1);

}


//페이지 클릭 이벤트  
document.getElementById('pagination').addEventListener('click', function (event) {
	const target = event.target;

	if (target.tagName.toLowerCase() === 'a') {
		event.preventDefault(); // 기본 동작(페이지 이동) 막기

		const page = parseInt(target.innerHTML, 10); // 페이지 번호 가져오기
		if (!isNaN(page)) {
			displayPharmacies(pharmacies, totalPages, page); // 페이지 데이터 표시
		}
	}
});

function displayPagination(pharmacies, totalPages, currentPage) {

	const paginationEl = document.getElementById('pagination');
	const fragment = document.createDocumentFragment();

	const maxVisiblePages = 5; // 한 번에 표시할 페이지 수
	const startPage = Math.max(1, currentPage - Math.floor(maxVisiblePages / 2));
	const endPage = Math.min(totalPages, startPage + maxVisiblePages - 1);

	// 기존 버튼 제거
	while (paginationEl.hasChildNodes()) {
		paginationEl.removeChild(paginationEl.lastChild);
	}

	// "이전" 버튼 추가
	if (currentPage > 1) {
		const prevEl = document.createElement('a');
		prevEl.href = '#';
		prevEl.innerHTML = '<';
		prevEl.addEventListener('click', (event) => {
			event.preventDefault();
			displayPharmacies(pharmacies, currentPage - 1, totalPages);
		});
		fragment.appendChild(prevEl);
	}

	// 페이지 번호 추가
	for (let i = startPage; i <= endPage; i++) {
		const el = document.createElement('a');
		el.href = '#';
		el.innerHTML = i;

		// 현재 페이지 강조
		if (i === currentPage) {
			el.classList.add('on');
		}

		el.addEventListener('click', (event) => {
			event.preventDefault();
			displayPharmacies(pharmacies, i, totalPages);
		});

		fragment.appendChild(el);
	}

	// "다음" 버튼 추가
	if (currentPage < totalPages) {
		const nextEl = document.createElement('a');
		nextEl.href = '#';
		nextEl.innerHTML = '>';
		nextEl.addEventListener('click', (event) => {
			event.preventDefault();
			displayPharmacies(pharmacies, currentPage + 1, totalPages);
		});
		fragment.appendChild(nextEl);
	}

	paginationEl.appendChild(fragment);
}


function displayMarkers(pharmacies) {

	removeMarker();
	
	pharmacies.forEach((pharmacy, index) => {
		var position = new kakao.maps.LatLng(pharmacy.latitude, pharmacy.longitude);
		var marker = new kakao.maps.Marker({
			map: map, 
			position: position 
		});
		markers.push(marker);

		var title = pharmacy.name;

		(function(marker, title) {
			kakao.maps.event.addListener(marker, 'mouseover', function() {
				displayInfowindow(marker, title);
			});

			kakao.maps.event.addListener(marker, 'mouseout', function() {
				infowindow.close();
			}); 
		})(marker, title);
	});

	// 첫 번째 약국의 위치로 지도 중심 이동
	if (pharmacies.length > 0) {
		var centerPosition = new kakao.maps.LatLng(pharmacies[0].latitude, pharmacies[0].longitude);
		map.setCenter(centerPosition);
	}
}

function removeMarker() {
	for ( var i = 0; i < markers.length; i++ ) {
		markers[i].setMap(null);
	}   
	markers = [];
}

function closePopup() {
    const popup = document.querySelector('.detail-popup');
    if (popup) {
        popup.style.display = 'none';
    }
}


function handleClosePopup(event) {
    const target = event.target;

    if (target.classList.contains('close-popup')) {
        const popup = document.querySelector('.detail-popup');
        popup.style.display = 'none';
    }
}

document.addEventListener('click', handleClosePopup);


// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title) {
	var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

	infowindow.setContent(content);
	infowindow.open(map, marker);
}

// 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {   
	while (el.hasChildNodes()) {
		el.removeChild (el.lastChild);
	}
}










// function placesSearchCB(data, status, pagination) {
// 	if (status === kakao.maps.services.Status.OK) {
// 		var totalPages = Math.ceil(data.length / 10); // 총 페이지 수 계산
// 		displayPlaces(data.slice(0, 10)); // 첫 페이지 데이터만 표시
// 		displayPagination(totalPages, 1, data); // 첫 페이지로 페이징 설정
// 	} else if (status === kakao.maps.services.Status.ZERO_RESULT) {
// 		alert('검색 결과가 존재하지 않습니다.');
// 	} else if (status === kakao.maps.services.Status.ERROR) {
// 		alert('검색 결과 중 오류가 발생했습니다.');
// 	}
// }

// 검색 결과 목록과 마커를 표출하는 함수입니다
// function displayPlaces(places) {
// 	var listEl = document.getElementById('placesList'),
// 		menuEl = document.getElementById('menu_wrap'),
// 		fragment = document.createDocumentFragment(),
// 		bounds = new kakao.maps.LatLngBounds(),
// 		listStr = '';

// 	// 검색 결과 목록에 추가된 항목들을 제거합니다
// 	removeAllChildNods(listEl);

// 	// 지도에 표시되고 있는 마커를 제거합니다
// 	removeMarker();

// 	// 현재 페이지와 페이지당 표시할 개수 설정
// 	var currentPage = 1;
// 	var itemsPerPage = 10;
// 	var totalPages = Math.ceil(places.length / itemsPerPage);

// 	// 현재 페이지의 시작 인덱스와 종료 인덱스 계산
// 	var startIdx = (currentPage - 1) * itemsPerPage;
// 	var endIdx = startIdx + itemsPerPage;

// 	// 페이지 데이터 가져오기
// 	var currentPlaces = places.slice(startIdx, endIdx);

// 	for (var i = 0; i < currentPlaces.length; i++) {
// 		// 마커를 생성하고 지도에 표시합니다
// 		var placePosition = new kakao.maps.LatLng(currentPlaces[i].y, currentPlaces[i].x),
// 			marker = addMarker(placePosition, i),
// 			itemEl = getListItem(i, currentPlaces[i]); // 검색 결과 항목 Element를 생성합니다

// 		// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기 위해
// 		// LatLngBounds 객체에 좌표를 추가합니다
// 		bounds.extend(placePosition);

// 		// 마커와 검색결과 항목에 mouseover 했을 때
// 		// 해당 장소에 인포윈도우에 장소명을 표시합니다
// 		(function (marker, title) {
// 			kakao.maps.event.addListener(marker, 'mouseover', function () {
// 				displayInfowindow(marker, title);
// 			});

// 			kakao.maps.event.addListener(marker, 'mouseout', function () {
// 				infowindow.close();
// 			});

// 			itemEl.onmouseover = function () {
// 				displayInfowindow(marker, title);
// 			};

// 			itemEl.onmouseout = function () {
// 				infowindow.close();
// 			};
// 		})(marker, currentPlaces[i].place_name);

// 		fragment.appendChild(itemEl);
// 	}

// 	// 검색결과 항목들을 검색결과 목록 Element에 추가합니다
// 	listEl.appendChild(fragment);
// 	menuEl.scrollTop = 0;

// 	// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
// 	map.setBounds(bounds);

// 	// 페이지 번호를 생성합니다
// 	displayPagination(totalPages, currentPage, places);
// }


// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
// function addMarker(position, idx, title) {
// 	var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
// 		imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
// 		imgOptions =  {
// 			spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
// 			spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
// 			offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
// 		},
// 		markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
// 			marker = new kakao.maps.Marker({
// 			position: position, // 마커의 위치
// 			image: markerImage 
// 		});

// 	marker.setMap(map); // 지도 위에 마커를 표출합니다
// 	markers.push(marker);  // 배열에 생성된 마커를 추가합니다

// 	return marker;
// }

 

