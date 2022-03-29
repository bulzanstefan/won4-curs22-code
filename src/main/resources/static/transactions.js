$(document).ready(() => {
    let transactionToEdit;

    $('#add-button-modal').click(() => {
        //extragem valorile introduse in modal
        const description = $('#modal-description').val();
        const amount = $('#modal-amount').val();
        const type = $('#modal-type').val();

        //construim noul obiect transaction din modal
        const newTransaction = {
            description: description,
            amount: amount,
            type: type
        };

        if (transactionToEdit == null) {
            addTransaction(newTransaction);
        } else {
            editTransaction(transactionToEdit, newTransaction)
        }
    });

    function editTransaction(id, newTransaction) {
        fetch('api/transactions/' + id, {
            method: 'PUT',
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
    }

    function addTransaction(newTransaction) {
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
    }

    $('.edit-icon').click(function () {
        //extragem id-ul din html, de pe parintele iconitei de edit
        transactionToEdit = this.parentElement.id;
        //extragem elementul din html care reprezinta randul unui tabel
        const row = this.parentElement.parentElement;
        //extragem textul din prima casuta din row
        const description = row.children[0].innerText;
        const type = row.children[1].innerText;
        const amount = row.children[2].innerText;

        //setam valoarea in html pt modal
        $('#modal-description').val(description);
        $('#modal-amount').val(amount);
        $('#modal-type').val(type);
    });

    $('.delete-icon').click(function () {
        const transactionId = this.parentElement.id;

        fetch('api/transactions/' + transactionId, {
            method: 'DELETE'
        }).then(response => location.reload());
    });

    $('#add-transaction-button').click(function () {
        transactionToEdit = null;
        clearModal();
    });

    function clearModal() {
        $('#modal-description').val('');
        $('#modal-amount').val('');
        $('#modal-type').val('');
    }
});