$(document).ready(function(){
    $.getJSON("/api/clienti", function(data){
        $.each(data, function(index, value){
            let button = `<button class="btn btn-danger" data-id="${value.id}" data-rowid="row_${value.id}">Elimina</button>`; 
            $("#clienti").append(`<tr id="row_${value.id}"><td>${value.id}</td><td>${value.cognome}</td><td>${value.nome}</td><td>${value.numeroTelefono}</td><td>${button}</td></tr>`);
            $(`button[data-id='${value.id}']`).on("click", eliminaCliente);
        });
    });
});

function eliminaCliente(e){
	let id = $(e.target).data("id");
	let rowId = $(e.target).data("rowid");
	$.ajax({
            type:"post",
            url:"api/eliminaCliente",
            data:{
               id:id
            }
        }).done(function(res){
            alert("cliente eliminato con successo");
            $(`#${rowId}`).remove();
        });	
}

$("#btn_aggiungi_cliente").on("click", aggiungi_cliente);

function aggiungi_cliente(){
    const nome = $("#nome").val();
    const cognome = $("#cognome").val();
    const numeroTelefono = $("#numeroTelefono").val();

    if(nome.length > 3 && cognome.length > 3 && numeroTelefono.length > 3){
        $.ajax({
            type: "post",
            url: "api/addCliente",
            data: {
                nome: nome,
                cognome: cognome,
                numeroTelefono: numeroTelefono
            }
        }).done(function(id){
            alert("cliente inserito con successo");
            $("#clienti").append(`<tr id="row_${id}"><td>${id}</td><td>${cognome}</td><td>${nome}</td><td>${numeroTelefono}</td><td><button class="btn btn-danger" data-id="${id}" data-rowid="row_${id}"> elimina </button></td></tr>`);
            $(`button[data-id='${id}']`).on("click",eliminaCliente);
           
            $("#nome").val("");
            $("#cognome").val("");
            $("#numeroTelefono").val("")
        });
    } else {
        alert("I valori inseriti non sono corretti");
    }
}
