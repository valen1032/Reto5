const tableBody = document.getElementById("tableBody")
const inputId = document.getElementById("inputId")
const inputScore = document.getElementById("inputScore")
const contenedorId = document.getElementById("contenedorId")
const btnModalFooter = document.getElementsByClassName("btn-modal-footer")

function obtener(){
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch("http://164.152.22.41/api/Score/all", requestOptions)
    .then(response => response.json())
    .then(result =>{
        result.forEach(element => {
            tableBody.innerHTML += `
            <tr>

                <td>${element.score}</td>
                <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#modal" onclick="btnDetails(${element.idScore})">
                    Details
                </button>
                </td>
            </tr>
            `
        });
    })
    .catch(error => console.log('error', error));
}

function obtenerPorId(id){
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch(`http://164.152.22.41/api/Score/${id}`, requestOptions)
    .then(response => response.json())
    .then(result => {
        inputId.value = result.idScore
        inputScore.value = result.score
    })
    .catch(error => console.log('error', error));

}

function eliminar(){
    var requestOptions = {
        method: 'DELETE',
        redirect: 'follow'
    };
    fetch(`http://164.152.22.41/api/Score/${inputId.value}`, requestOptions)
    .then(response => window.location.reload())
    .catch(error => console.log('error', error));
}

function actualizar(){
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "idScore": inputId.value,
        "score": inputScore.value
    });

    var requestOptions = {
        method: 'PUT',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };
    fetch("http://164.152.22.41/api/Score/update", requestOptions)
    .then(response => {
        window.location.reload()
    })
    .catch(error => console.log('error', error));
}

function crear(){
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "score": inputScore.value
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("http://164.152.22.41/api/Score/save", requestOptions)
    .then(response => {
        if(response.status == 201){
            window.location.reload()
        }
    })
    .catch(error => console.log('error', error));
}

function limpiarInput(){
    inputId.value = null
    inputScore.value = null
}

function btnAdd(){
    btnModalFooter[0].style.display = "block"
    btnModalFooter[1].style.display = "none"
    btnModalFooter[2].style.display = "none"
    contenedorId.style.display = "none"
    limpiarInput()
}

function btnDetails(id){
    btnModalFooter[0].style.display = "none"
    btnModalFooter[1].style.display = "block"
    btnModalFooter[2].style.display = "block"
    contenedorId.style.display = "block"
    obtenerPorId(id)
}

obtener()

