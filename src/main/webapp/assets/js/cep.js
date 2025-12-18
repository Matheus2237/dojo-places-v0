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