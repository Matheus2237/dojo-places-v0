function formatCep() {
    const cepInput = document.getElementById('cep');
    if (!cepInput) return;

    let cep = cepInput.value.replace(/\D/g, '');

    if (cep.length > 8) {
        cep = cep.substring(0, 8);
    }

    if (cep.length > 5) {
        cepInput.value = cep.substring(0, 5) + '-' + cep.substring(5);
    }
}

function findCep() {
    const cepInput = document.getElementById('cep');
    if (!cepInput) return;

    const cep = cepInput.value.replace(/\D/g, '').padStart(8, '0');

    fetch('/cep/' + cep)
        .then(res => res.json())
        .then(data => {
            if (data && !data.error) {
                const neighborhoodField = document.getElementById('neighborhood');
                const cityField = document.getElementById('city');
                if (neighborhoodField) neighborhoodField.value = data['neighborhood'] || '';
                if (cityField) cityField.value = data['city'] || '';
            } else {
                alert('CEP não encontrado');
            }
        })
        .catch(error => {
            alert('Erro ao buscar CEP');
        })
}