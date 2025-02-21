$(document).ready(function() {
    $(".solve-btn").hover(
        function() {
            $(this).attr("src", "/img/qna/solved.png");
        },
        function() {
            $(this).attr("src", "/img/qna/authorUnsolved.png");
        }
    );
});

$(document).ready(function() {
    $('.solve-btn').on('click', function() {
        var button = $(this);
        var seq = button.closest('.qna-solved').find('.question-id').val();
        var csrfToken = $('meta[name="_csrf"]').attr('content');
        var csrfHeader = $('meta[name="_csrf_header"]').attr('content');
				
        $.ajax({
            url: '/solvedQuestion/' + seq, // seq 값을 URL 경로에 포함
            type: 'POST',
            beforeSend: function(xhr) {
                xhr.setRequestHeader(csrfHeader, csrfToken); // CSRF 토큰 헤더에 추가
            },
            success: function(response) {
				location.reload(); 
            },
            error: function(a, b, c) {
                alert('에러가 발생했습니다. 다시 시도해주세요.');
            }
        });
    });
});

function deleteQuestion(seq) {
    if (!confirm("정말 삭제하시겠습니까?")) return;

    fetch(`/delQuestion/${seq}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
            "X-CSRF-TOKEN": document.querySelector("meta[name='_csrf']").content
        }
    })
    .then(response => {
        if (response.ok) {
            alert("삭제되었습니다.");
            window.location.href = "/qna";
        } else {
            response.text().then(msg => alert(msg));
        }
    })
    .catch(error => console.error("Error:", error));
}

$('.btn-delete').click(function(e) {
    e.preventDefault();
    if(confirm('정말 삭제하시겠습니까?')) {
        var url = $(this).attr('href');
		console.log(url);
        $.ajax({
            url: url,
            type: 'DELETE',
			headers: {
	            "Content-Type": "application/json",
	            "X-CSRF-TOKEN": document.querySelector("meta[name='_csrf']").content
	        },
            success: function(result) {
                alert('삭제가 완료되었습니다.');
				location.reload(); 
            },
            error: function(xhr, status, error) {
                alert('삭제 실패: ' + error);
            }
        });
    }
});


