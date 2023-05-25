const tableBody = document.getElementById("tableBody")
const inputId = document.getElementById("inputId")
const selectClient = document.getElementById("selectClient")
const selectCar = document.getElementById("selectCar")
const inputstart = document.getElementById("inputstart")
const inputdevolution = document.getElementById("inputdevolution")
const inputStatus = document.getElementById("inputStatus")
const contenedorId = document.getElementById("contenedorId")
const btnModalFooter = document.getElementsByClassName("btn-modal-footer")

function obtener(){
var requestOptions = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://164.152.22.41/api/Reservation/all", requestOptions)
  .then(response => response.json())
    .then(result => {
      result.forEach(element => {
        tableBody.innerHTML += `
        <tr>
            <td>${element.startDate}</td>
            <td>${element.devolutionDate}</td>
            <td>${element.status}</td>
            <td>${element.car.name}</td>
            <td>${element.client.name}</td>

            <td>
            <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#modal" onclick="btnDetails(${element.idReservation})">
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

fetch(`http://164.152.22.41/api/Reservation/${id}`, requestOptions)
  .then(response => response.json())
  .then(result => {
    inputId.value = result.idReservation
    inputstart.value = result.startDate
    inputdevolution.value = result.devolutionDate
    inputStatus.value = result.status
    selectCar.innerHTML = `<option>${result.car.name}</option>`
    selectClient.innerHTML = `<option>${result.client.name}</option>`
  })
  .catch(error => console.log('error', error));
}

function eliminar(){
  var requestOptions = {
    method: 'DELETE',
    redirect: 'follow'
  };
  fetch(`http://164.152.22.41/api/Reservation/${inputId.value}`, requestOptions)
  .then(response => window.location.reload())
  .catch(error => console.log('error', error));
}
function actualizar(){
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  var raw = JSON.stringify({
    "idReservation": inputId.value,
    "startDate": inputstart.value,
    "devolutionDate": inputdevolution.value,
    "status": inputStatus.value
  });

  var requestOptions = {
    method: 'PUT' ,
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
  };
  fetch("http://164.152.22.41/api/Reservation/update", requestOptions)
  .then(response => {
    window.location.reload()
  })
  .catch(error => console.log('error', error));
}


function crear(){
    var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify({
  "startDate": inputstart.value,
  "devolutionDate": inputdevolution.value,
  "client": {
    "idClient": selectClient.value,
  },
  "car": {
    "idCar": selectCar.value,
  },
  "status": inputStatus.value
});

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://164.152.22.41/api/Reservation/save", requestOptions)
  .then(response => {
    if(response.status == 201){
    window.location.reload()
    }
  })
  .catch(error => console.log('error', error));
}

function reportDate(){

var requestOptions = {
  method: 'GET',
  body: raw,
  redirect: 'follow'
};

fetch(`http://164.152.22.41/api/Reservation/report-dates/2020-01-01/2020-12-31`, requestOptions)
  .then(response => response.json())
  .then(result =>console.log(result))
  .catch(error => console.log('error', error));
}

function reportStatus(){

var requestOptions = {
  method: 'GET',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://164.152.22.41/api/Reservation/report-status", requestOptions)
  .then(response => response.json())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
}

function reportClients(){

var requestOptions = {
  method: 'GET',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://164.152.22.41/api/Reservation/report-clients", requestOptions)
  .then(response => response.json())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
}1

function obtenerCars(){
    selectCar.innerHTML = null
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch("http://164.152.22.41/api/Car/all", requestOptions)
    .then(response => response.json())
    .then(result => {
        result.forEach(element => {
            selectCar.innerHTML += `<option value="${element.idCar}">${element.name}</option>`
        });
    })
    .catch(error => console.log('error', error));
}

function obtenerClients(){
    selectClient.innerHTML = null
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch("http://164.152.22.41/api/Client/all", requestOptions)
    .then(response => response.json())
    .then(result => {
        result.forEach(element => {
            selectClient.innerHTML += `<option value="${element.idClient}">${element.name}</option>`
        });
    })
    .catch(error => console.log('error', error));
}


function limpiarInput(){
    inputId.value = null;
    inputstart.value = null;
    inputdevolution.value = null;
    inputStatus.value = null;
}


function btnAdd(){
    btnModalFooter[0].style.display = "block"
    btnModalFooter[1].style.display = "none"
    btnModalFooter[2].style.display = "none"
    contenedorId.style.display = "none"
    selectCar.disabled = false
    selectClient.disabled = false
    limpiarInput()
    obtenerCars()
    obtenerClients()
}


function btnDetails(id){
    btnModalFooter[0].style.display = "none"
    btnModalFooter[1].style.display = "block"
    btnModalFooter[2].style.display = "block"
    contenedorId.style.display = "block"
    selectCar.disabled = true
    selectClient.disabled = true
    obtenerPorId(id)

}
obtener()