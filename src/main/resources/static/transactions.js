$(document).ready(() => {
    $('#add-button-modal').click(() => {
        const description = $('#modal-description').val();
        const amount = $('#modal-amount').val();
        const type = $('#modal-type').val();

        const newTransaction = {
            description: description,
            amount: amount,
            type: type
        };

        fetch('api/transactions', {
            method: 'POST',
            body: JSON.stringify(newTransaction),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert("There are errors " + response.status);
            }
        });
    });

    $('.delete-icon').click(function () {
        const transactionId = this.parentElement.id;

        fetch('api/transactions/' + transactionId, {
            method: 'DELETE'
        }).then(response => location.reload());
    });
});