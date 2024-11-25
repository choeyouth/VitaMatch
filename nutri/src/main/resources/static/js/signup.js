/* ID 중복 체크 */
document.getElementById('checkId').addEventListener('click', function() {
    const id = document.getElementById('id').value;
    fetch(`/checkId?id=${id}`)
        .then(response => response.json())
        .then(data => {
            const message = data.available ? 'ID is available' : 'ID is already taken';
            document.getElementById('idCheckMessage').textContent = message;
        });
});

/* 비밀번호 유효성 검사 및 비밀번호/비밀번호 확인 동일 검사 */
const passwordInput = document.getElementById('password');
const passwordCheckInput = document.getElementById('passwordCheck');
const passwordValiditySpan = document.getElementById('passwordValidity');
const passwordMatchSpan = document.getElementById('passwordMatch');

/* 전화번호 포커스 변경 */
passwordInput.addEventListener('input', function() {
    const isValid = /^[A-Za-z0-9!@#$%^&*]{8,30}$/.test(passwordInput.value);
    passwordValiditySpan.textContent = isValid ? '' : 'Password must be 8-30 characters with letters, numbers, and special characters.';
});

passwordCheckInput.addEventListener('input', function() {
    const isMatch = passwordInput.value === passwordCheckInput.value;
    passwordMatchSpan.textContent = isMatch ? '' : 'Passwords do not match.';
});

const phoneInputs = document.querySelectorAll('.phone-input');
phoneInputs.forEach((input, index) => {
    input.addEventListener('input', function() {
        if (input.value.length === input.maxLength && phoneInputs[index + 1]) {
            phoneInputs[index + 1].focus();
        }
    });
});
