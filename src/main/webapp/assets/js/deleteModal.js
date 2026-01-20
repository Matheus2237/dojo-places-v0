let formToSubmit = null;

function openDeleteModal(button) {
    formToSubmit = button.closest('form');

    const modalElement = document.getElementById('deleteConfirmModal');
    const modal = new bootstrap.Modal(modalElement);

    modal.show();
}

document.addEventListener('DOMContentLoaded', function () {
    const confirmButton = document.getElementById('confirmDeleteBtn');

    confirmButton.addEventListener('click', function () {
        if (formToSubmit) {
            formToSubmit.submit();
        }
    });
});
