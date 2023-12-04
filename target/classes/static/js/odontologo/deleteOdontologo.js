function deleteBy(id){

      mostrarModalConfirmacion("¿Está seguro que desea eliminar el odontologo?", () => {


      console.log("eliminando Odontologo " + id)
      const url = 'http://localhost:8081/odontologos/eliminar/'+ id;
      const settings = {
          method: 'DELETE'
      };

      fetch(url, settings)
          .then((response) => {
             if (!response.ok) {
                throw new Error('Error al eliminar el odontologo');
                }
            response.json();
          })
          .then((data) => {
            console.log(data);
            let row_id = "#tr_" + id;
            document.querySelector(row_id).remove();
            setTimeout(() => {
                 window.location.reload();
             }, 2000);
          })
          .catch((error) => mostrarModal(error));
      });
};

function mostrarModal(mensaje) {

  const modal = document.getElementById('responseModal');
  const modalMensaje = modal.querySelector('.modal-body');
  modalMensaje.textContent = mensaje;
  const miModal = new bootstrap.Modal(modal);
  miModal.show();

}

function mostrarModalConfirmacion(mensaje, callback) {
  const modal = document.getElementById('miModalConfirmacion');
  const modalMensaje = modal.querySelector('.modal-body');
  modalMensaje.textContent = mensaje;
  const btnAceptar = modal.querySelector('#btnAceptar');
  btnAceptar.addEventListener('click', callback);
  const miModal = new bootstrap.Modal(modal);
  miModal.show();
};




