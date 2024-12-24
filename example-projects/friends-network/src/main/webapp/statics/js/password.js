document.addEventListener('DOMContentLoaded', () => {
	const url = `${window.location}/settings/password`
	
	const oldPasswordError = document.getElementById("oldPasswordError")
	const confirmPasswordError = document.getElementById("confirmPasswordError")
	
	const oldPasswordInput = document.getElementById("oldPassword")
	const newPasswordInput = document.getElementById("newPassword")
	const confirmPasswordInput = document.getElementById("confirmPassword")
	
	const btn = document.getElementById("passwordBtn")
	let isOldPasswordCorrect = false
	let isPasswordMatch = false

	const checkPassword = () => {
		fetch(`${url}?oldPassword=${oldPasswordInput.value}`)
			.then(res => res.json())
			.then(data => {
				if(data.isCorrect) {
					isOldPasswordCorrect = data.isCorrect
					if(!oldPasswordError.classList.contains("d-none")) {
						oldPasswordError.classList.add("d-none")
					}
				} else {
					isOldPasswordCorrect = false
					oldPasswordError.classList.remove("d-none")
				}
				validBtn()
			})
	}
	
	const checkConfirmPassword = () => {
		if(confirmPasswordInput.value === newPasswordInput.value) {
			if(!confirmPasswordError.classList.contains("d-none")) {
				isPasswordMatch = true
				confirmPasswordError.classList.add("d-none")
			}
		} else {
			isPasswordMatch = false
			confirmPasswordError.classList.remove("d-none")
		}
		validBtn()
	}
	
	const validBtn = () => {
		if(isOldPasswordCorrect && isPasswordMatch 
		&& oldPasswordInput.value 
		&& newPasswordInput.value
		&& confirmPasswordInput.value) {
			btn.removeAttribute("disabled")
		} else {
			if(!btn.getAttribute("disabled")) {
				btn.setAttribute("disabled", "disabled")
			}
		}
	}
	
	oldPasswordInput.addEventListener('keyup', () => isOldPasswordCorrect || isPasswordMatch || newPasswordInput.value || confirmPasswordInput.value ? checkPassword() : '')
	
	newPasswordInput.addEventListener('focus', () => oldPasswordInput.value && !isOldPasswordCorrect ? checkPassword() : '')
	confirmPasswordInput.addEventListener('focus', () => oldPasswordInput.value && !isOldPasswordCorrect ? checkPassword() : '')

	newPasswordInput.addEventListener('keyup', () => {
		if(confirmPasswordInput.value) {
			checkConfirmPassword()
		}
	})

	newPasswordInput.addEventListener('change', () => {
		if(confirmPasswordInput.value) {
			checkConfirmPassword()
		}
	})

	confirmPasswordInput.addEventListener('keyup', () => {
		checkConfirmPassword()
	})	
	
	confirmPasswordInput.addEventListener('change', () => {
		checkConfirmPassword()
	})
	
	document.getElementById("change-password").addEventListener('hide.bs.modal', () => {
		oldPasswordInput.value = ''
		newPasswordInput.value = ''
		confirmPasswordInput.value = ''
	})

})