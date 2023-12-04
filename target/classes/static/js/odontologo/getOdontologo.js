window.addEventListener('load', function () {
    (function(){
      const url = 'http://localhost:8081/odontologos/listar';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
         for(odontologo of data){
            var table = document.getElementById("odontologoTable");
            var odontologoRow =table.insertRow();
            let tr_id = 'tr_' + odontologo.id;
            odontologoRow.id = tr_id;

            let deleteButton ='<button' +
                                                                    ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                                                                    ' type="button" onclick="deleteBy('+paciente.id+')">' +
                                                                    '<i class="fas fa-trash-alt" id="delete"></i>' +
                                                                    '</button>';

            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                      ' type="button" onclick="findBy('+odontologo.id+')">' +
                                        '<i class="fas fa-pen-alt" id="edit"></i>' +
                                      '</button>';

            odontologoRow.innerHTML = '<td>' + odontologo.id + '</td>' +
                    '<td class=\"td_nombre\">' + odontologo.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_apellido\">' + odontologo.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_matricula\">' + odontologo.matricula + '</td>' +
                    '<td>' + updateButton + '</td>'
                    '<td>' + deleteButton + '</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/listadoOdontologos.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


})