window.addEventListener('load', function () {

    const formulario = document.querySelector('#update_odontologos_form');

    formulario.addEventListener('submit', function (event) {

        event.preventDefault();
        const formData = {
            id: document.querySelector('#odontologo_id').value,
            matricula: document.querySelector('#numeroMatricula').value,
            nombre: document.querySelector('#nombreOdontologo').value,
            apellido: document.querySelector('#apellidoOdontologo').value,
        };

        const url = 'http://localhost:8081/odontologos/actualizar';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        };

            fetch(url, settings)
                .then(response => {
                    console.log(response);
                    if (!response.ok) {
                        throw new Error("Error al actualizar el odontologo");
                        }
                    return response.json();
                })
                .then(data => {
                    console.log(data);
                    mostrarModal("Odontologo actualizado con exito");
                    document.querySelector("#form_update").classList.remove("form-body");
                    document.querySelector("#form_update").classList.add("form-body-hide");
                    setTimeout(() => {
                        window.location.reload();
                    }, 2000);
                })
                .catch(error => {
                    mostrarModal(error);
                });
    })
})

    function findBy(id) {
          const url = "http://localhost:8081/odontologos/" + id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let odontologo = data;
              document.querySelector('#odontologo_id').value = odontologo.id;
              document.querySelector('#numeroMatricula').value = odontologo.matricula;
              document.querySelector('#nombreOdontologo').value = odontologo.nombre;
              document.querySelector('#apellidoOdontologo').value = odontologo.apellido;
              document.querySelector("#form_update").classList.remove("form-body-hide");
              document.querySelector("#form_update").classList.add("form-body");
          }).catch(error => {
              alert("Error: " + error);
          })
      }

      function mostrarModal(mensaje) {
        const modal = document.getElementById('miModal');
        const modalMensaje = modal.querySelector('.modal-body');
        modalMensaje.textContent = mensaje;
        const miModal = new bootstrap.Modal(modal);
        miModal.show();
      }



