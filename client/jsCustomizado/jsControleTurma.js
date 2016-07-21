function buscarTurma(callback){
  $.ajax({
        type: 'GET',
        url: "http://localhost:8081/turma/buscarSeries",
        crossDomain: true,
        dataType: "json",
        data: {}
    }).done(function(json){
        callback(json);
    });
}
