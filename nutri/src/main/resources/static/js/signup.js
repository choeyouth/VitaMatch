// ID Duplicate Check
document.getElementById('checkId').addEventListener('click', function () {
    const id = document.getElementById('id').value;
    fetch(`/checkId?id=${id}`)
        .then(response => response.json())
        .then(data => {
            const message = data.available ? 'ID is available' : 'ID is already taken';
            document.getElementById('idCheckMessage').textContent = message;
        });
});

// Password Validity Check
const passwordInput = document.getElementById('password');
const passwordCheckInput = document.getElementById('passwordCheck');
const passwordValiditySpan = document.getElementById('passwordValidity');
const passwordMatchSpan = document.getElementById('passwordMatch');

passwordInput.addEventListener('input', function () {
    const password = passwordInput.value;

    // Regular expressions for each character group
    const hasEnglish = /[A-Za-z]/.test(password); // Checks for English letters
    const hasNumber = /[0-9]/.test(password); // Checks for numbers
    const hasSpecial = /[!@#$%^&*]/.test(password); // Checks for special characters
    const isValidLength = password.length >= 8 && password.length <= 30; // Checks for length
	const isEmpty = password.length == 0; //check for empty input

    // Update validity message
    if 	(isEmpty) {
		passwordValiditySpan.textContent = ''; // Empty password
	    passwordValiditySpan.classList.remove('active'); // Hide
	} else if (!isValidLength) {
        passwordValiditySpan.textContent = 'Password must be 8-30 characters.';
        passwordValiditySpan.classList.add('active'); // Make visible
    } else if (!hasEnglish) {
        passwordValiditySpan.textContent = 'Password must include at least one English letter.';
        passwordValiditySpan.classList.add('active');
    } else if (!hasNumber) {
        passwordValiditySpan.textContent = 'Password must include at least one number.';
        passwordValiditySpan.classList.add('active');
    } else if (!hasSpecial) {
        passwordValiditySpan.textContent = 'Password must include at least one special character (!@#$%^&*).';
        passwordValiditySpan.classList.add('active');
    } else {
        passwordValiditySpan.textContent = ''; // Valid password
        passwordValiditySpan.classList.remove('active'); // Hide
    }
});

passwordCheckInput.addEventListener('input', function () {
    const isMatch = passwordInput.value === passwordCheckInput.value;
    passwordMatchSpan.textContent = isMatch ? '' : 'Passwords do not match.';
    if (!isMatch) {
        passwordMatchSpan.classList.add('active');
    } else {
        passwordMatchSpan.classList.remove('active');
    }
});

// Phone Number Validation
const phoneInputs = document.querySelectorAll('.phone-input');

function validatePhoneNumber(input) {
    const isCellValid = /^[0-9]*$/.test(input.value); // Check for numbers only
    const errorMessageSpan = input.parentNode.querySelector('.error-message'); // Get the sibling span for the input

    if (!isCellValid) {
        errorMessageSpan.textContent = 'Only numbers are allowed.';
        errorMessageSpan.classList.add('active');
        input.value = input.value.replace(/[^0-9]/g, ''); // Remove invalid characters
    } else {
        errorMessageSpan.textContent = '';
        errorMessageSpan.classList.remove('active');
    }
}

phoneInputs.forEach((input, index) => {
    input.addEventListener('input', function () {
        validatePhoneNumber(input);

        if (input.value.length === input.maxLength && phoneInputs[index + 1]) {
            phoneInputs[index + 1].focus();
        }
    });

    input.addEventListener('paste', function (event) {
        const pasteData = (event.clipboardData || window.clipboardData).getData('text');
        if (!/^[0-9]*$/.test(pasteData)) {
            event.preventDefault();
        }
    });
});

// Address API Integration (Daum Postcode)
function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function (data) {
            let addr = ''; // Address variable
            let extraAddr = ''; // Extra address variable

            if (data.userSelectedType === 'R') {
                addr = data.roadAddress;
            } else {
                addr = data.jibunAddress;
            }

            if (data.userSelectedType === 'R') {
                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                    extraAddr += data.bname;
                }
                if (data.buildingName !== '' && data.apartment === 'Y') {
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if (extraAddr !== '') {
                    extraAddr = ' (' + extraAddr + ')';
                }
                document.getElementById('extraAddress').value = extraAddr;
            } else {
                document.getElementById('extraAddress').value = '';
            }

            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById('address').value = addr;
            document.getElementById('detailAddress').focus();
        }
    }).open();
}
