$(document).ready(function () {
    $.getJSON("/api/pratiche", function (data) {
      $.each(data, function (index, value) {
        let button = `<button class="btn btn-danger" data-id="${value.id}" data-rowid="row_${value.id}">Elimina</button>`;
        let row = $(`<tr id="row_${value.id}"><td>${value.id}</td><td>${value.dataApertura}</td><td>${value.dataChiusura}</td><td>${value.descrizione}</td><td>${button}</td></tr>`);
        $("#pratiche").append(row);
        bindEliminaButton(row.find("button"));
      });
    });
  });
  
  function bindEliminaButton(button) {
    button.on("click", eliminaPratica);
  }
  
  function eliminaPratica(e) {
    let id = $(e.target).data("id");
    let rowId = $(e.target).data("rowid");
    $.ajax({
      type: "post",
      url: "api/eliminaPratica",
      data: {
        id: id
      }
    }).done(function (res) {
      alert("Pratica eliminata con successo");
      $(`#${rowId}`).remove();
    });
  }
  
  $("#btn_aggiungi_pratica").on("click", aggiungi_pratica);
  
  function aggiungi_pratica() {
    const dataApertura = new Date($("#dataApertura").val());
    const dataChiusura = new Date($("#dataChiusura").val());
    const descrizione = $("#descrizione").val();
  
    if (dataApertura !== "" && dataChiusura !== "" && descrizione.length > 3) {
      $.ajax({
        type: "post",
        url: "api/addPratica",
        data: {
          dataApertura: dataApertura,
          dataChiusura: dataChiusura,
          descrizione: descrizione
        }
      }).done(function (id) {
        alert("Pratica inserita con successo");
        let button = `<button class="btn btn-danger" data-id="${id}" data-rowid="row_${id}">Elimina</button>`;
        let row = $(`<tr id="row_${id}"><td>${id}</td><td>${dataApertura}</td><td>${dataChiusura}</td><td>${descrizione}</td><td>${button}</td></tr>`);
        $("#pratiche").append(row);
        bindEliminaButton(row.find("button"));
  
        $("#dataApertura").val("");
        $("#dataChiusura").val("");
        $("#descrizione").val("");
      });
    } else {
      alert("I valori inseriti non sono corretti");
    }
  }
  