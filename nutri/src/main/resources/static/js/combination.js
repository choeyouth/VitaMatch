document.querySelector('input[type="radio"]').checked = true;
	
// CSRF 토큰과 헤더 이름을 메타 태그에서 동적으로 가져옵니다.
//var token = $("meta[name='_csrf']").attr("content");
//var header = $("meta[name='_csrf_header']").attr("content");


// 페이지 로딩 시 첫 번째 라디오 버튼에 해당하는 성분을 선택하여 처리
document.addEventListener('DOMContentLoaded', function() {
   
    let firstLabel = document.querySelector('label');
    let firstInput = document.querySelector('#' + firstLabel.getAttribute('for'));
    let firstIngredientSeq = firstInput.value;
    let firstIngredient = firstLabel.textContent.trim();

    // 첫 번째 라디오 버튼에 해당하는 성분을 표시
    selectIngredient(firstIngredientSeq, firstIngredient);
});



// 클릭된 label에 연결된 input 요소 가져오기
document.querySelectorAll('label').forEach(function (label) {
    label.addEventListener('click', function () {
        
        let input = document.querySelector('#' + label.getAttribute('for'));
        let ingredientSeq = input.value;
        let ingredient = label.textContent.trim();

        // selectIngredient 함수 호출
        selectIngredient(ingredientSeq, ingredient);
    });
});



// 성분을 업데이트하는 함수
function selectIngredient(ingredientSeq, ingredient) {
	// ajax 함수와 충돌나서 none으로 초기화 추가
	document.querySelector('#combinationBad').style.display = 'none';
	document.querySelector('#combinationGood').style.display = 'none';
	document.querySelector('#collapseOne').innerHTML ='';
	document.querySelector('#collapseTwo').innerHTML ='';

    // 라디오 버튼을 누르면 선택된 성분 보여주기로 변경
    document.querySelectorAll('.selectOne')[0].innerHTML = ingredient;
    document.querySelectorAll('.selectOne')[1].innerHTML = ingredient;

    // 라디오 버튼을 누르면 선택된 성분 이미지 보여주기로 변경
    let image = document.querySelector('#selectOneImg');
    image.src = '/img/ingredient/' + ingredient + '.png';

    // AJAX 요청
    $.ajax({
        type: 'POST',
        url: '/combination/ajax',  // 서버에 요청할 URL
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
            ingredientSeq: ingredientSeq,
            ingredient: ingredient
        }),
        success: function (response) {
			
			if (response.good && response.good.length > 0 && response.bad && response.bad.length > 0) {
			    // bad와 good 모두 있을 때
			    displayCombination('#combinationBad', response.bad[0].functionalContent);
			    displayCombination('#combinationGood', response.good[0].functionalContent);
			    addGoodCombinations(response.good);
			    addBadCombinations(response.bad);
			} else if (response.bad && response.bad.length > 0) {
			    // bad만 있을 때
			    displayCombination('#combinationBad', response.bad[0].functionalContent);
			    console.log('bad functionalContent: ' + response.bad[0].functionalContent);
			    addBadCombinations(response.bad);
			} else if (response.good && response.good.length > 0) {
			    // good만 있을 때
			    displayCombination('#combinationGood', response.good[0].functionalContent);
			    console.log('good functionalContent: ' + response.good[0].functionalContent);
			    addGoodCombinations(response.good);
			}
        },
        error: function (a, b, c) {
            console.log(a, b, c);
        }
    });
}



function displayCombination(elementId, content) {
	// 해당 요소의 display를 'block'으로 설정하고, content를 삽입
    document.querySelector(elementId).style.display = 'block';
    document.querySelector('#ingredientContent').innerHTML = content;
}

// 'good' 배열을 순회하면서 각 항목에 대한 HTML을 동적으로 추가하는 함수
function addGoodCombinations(goodArray) {
    // 'good' 배열이 존재하고 길이가 0보다 큰지 확인
    if (goodArray && goodArray.length > 0) {
      	let collapseOne = document.querySelector('#collapseOne');
      	
        // 새로운 요소를 만들고 해당 위치에 추가할 HTML 문자열을 생성
        let newElement = document.createElement('div'); // 하나의 div로 여러 항목을 감쌀 예정

        // 'good' 배열을 순회하면서 각 항목에 대한 HTML을 생성
        goodArray.forEach(function(item, index) {
            // 각 항목에 대해 HTML 요소 생성
            let goodItemHTML = `
            	<div class="accordion-body">
                	<div class="good_combination_title">${item.name}</div>
                	<div class="good_combination_content">${item.reason}</div>
                	<a class="good_combination_link" href="${item.link}" target="_blank">출처</a>
                </div>
            `;

            // 새로운 div 요소를 생성하여 HTML 삽입
        	let newElement = document.createElement('div');
        	newElement.innerHTML = goodItemHTML;

        	// #collapseTwo 내부에 새로운 항목 추가
        	collapseOne.appendChild(newElement);

       });
        

    } else {
        console.log('No good combinations available.');
    }
}

// 'bad' 배열을 순회하면서 각 항목에 대한 HTML을 동적으로 추가하는 함수
function addBadCombinations(badArray) {
    // 'bad' 배열이 존재하고 길이가 0보다 큰지 확인
    if (badArray && badArray.length > 0) {
        let collapseTwo = document.querySelector('#collapseTwo');

        // 새로운 요소를 만들고 해당 위치에 추가할 HTML 문자열을 생성
        let newElement = document.createElement('div'); // 하나의 div로 여러 항목을 감쌀 예정

        // 'good' 배열을 순회하면서 각 항목에 대한 HTML을 생성
        badArray.forEach(function(item, index) {
            // 각 항목에 대해 HTML 요소 생성
            let badItemHTML = `
            	<div class="accordion-body">
                	<div class="bad_combination_title">${item.name}</div>
                	<div class="bad_combination_content">${item.reason}</div>
                	<a class="bad_combination_link" href="${item.link}" target="_blank">출처</a>
                </div>
            `;

            // 새로운 div 요소를 생성하여 HTML 삽입
        	let newElement = document.createElement('div');
        	newElement.innerHTML = badItemHTML;

        	// #collapseTwo 내부에 새로운 항목 추가
        	collapseTwo.appendChild(newElement);

            // 콘솔에 로그 출력 (디버깅용)
            console.log(`bad[${index}] - Name: ${item.name}, Reason: ${item.reason}, Link: ${item.link}`);
        });

       
    } else {
        console.log('No bad combinations available.');
    }
}
	