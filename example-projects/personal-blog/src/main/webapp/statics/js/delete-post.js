document.addEventListener('DOMContentLoaded', () => {
	const btns = document.querySelectorAll(".delete-post-btn")
	if(btns) {
		btns.forEach(btn => {
			btn.addEventListener('click', () => {
				const modal = new bootstrap.Modal('#delete-post-modal')
				const input = document.getElementById("postId")
				input.value = btn.getAttribute("postId")
				modal.show()
			})
		})
	}
})