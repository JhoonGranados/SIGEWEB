function alunoController(){

}

alunoController.prototype = {
  buscarAlunos : function(){
    var url = "http://localhost:8081/aluno/buscar";
    var requestType = "GET";
    this.realizarRequest(requestType, url, renderizarTabelaAlunoComBaseJson, "");
  },

  buscarAlunosFiltro : function(filtro){
    var url = "http://localhost:8081/aluno/buscarFiltro/"+filtro;
    var requestType = "GET";
    this.realizarRequest(requestType, url, renderizarTabelaAlunoComBaseJson, "");
  },

  buscarAlunoPorMatricula : function(matricula, acao){
    var url = "http://localhost:8081/aluno/buscar/"+matricula;
    var requestType = "GET";
    this.realizarRequest(requestType, url, acao, "");
  },

  alterarAluno : function(acao){
    url = "http://localhost:8081/aluno/editar";
    requestType = "PUT";
    dataType = this.obterDadosDaTelaDeCadastroAluno();
    this.realizarRequest(requestType, url, acao, dataType);
  },

  buscarTurma : function(acao){
    url = "http://localhost:8081/turma/buscarSeries";
    var requestType = "GET";
    this.realizarRequest(requestType, url, acao, "")
  },

  salvarAluno : function(acao){
    url = "http://localhost:8081/aluno/salvar";
    requestType = "POST";
    dataType = this.obterDadosDaTelaDeCadastroAluno();
    this.realizarRequest(requestType, url, acao, dataType);
  },

  excluirAluno : function(matricula, acao){
    url = "http://localhost:8081/aluno/remove/" + matricula;
    requestType = "DELETE";
    this.realizarRequest(requestType, url, acao, "");
  },

  realizarRequest: function(requestType, url, acao, valores){
    waitingDialog.show();
    $.ajax({
          type: requestType,
          contentType: 'application/json',
          crossDomain: true,
          url: url,
          dataType: "json",
          data: valores
      }).done(function(json){
          acao(json);
          waitingDialog.hide();
      });
  },

  limparFormulario : function(formulario){
    formulario.reset();
  },

  renderizarTabelaAlunoComBaseJson : function(json){
    console.log(json);
    var $elTabelaAluno = $(".cadastrosPrincipais .tableAluno tbody");
  	var strTBody = "";

  	for(var i=0; i<json.length;i++){
  		strTBody +=""+
  		"<tr>" +
        		"<td>" + " " + " </td>" +
        		"<td>" + json[i].matricula + " </td>" +
  	        "<td>" + json[i].nome + " </td>" +
  	        "<td>" + json[i].sobrenome + " </td>" +
  	        "<td>" + json[i].turma + " </td>" +
  	        '<td><button type="button" style="width: 100px" onclick="mostrarInformacoesAdicionaisAluno(this)" data-id="'+json[i].matricula+'" '+
            'class="btn btn-info" data-target="#modalApresentarDadosAluno" data-toggle="modal">Visualizar</button>'+
  	        '&nbsp;&nbsp;<button type="button" style="width: 100px" class="btn btn-danger" onclick="getMatricula(this)">Excluir</button></td>'
  	    "<tr>";
    }
  },

  getMatricula : function(e){
      var tr = e.closest("tr");
      var tds = tr.getElementsByTagName('td');
      var matricula = tds[1].textContent;
      return matricula;
  },

  mostrarInformacoesAdicionaisAluno : function(btn){
    var matricula = this.getMatricula(btn);
    this.buscarAlunoPorMatricula(matricula, this.preecherInformacoesAluno);
  },

  preecherInformacoesAluno : function(json){
    var informacoesAdicionaisAluno = $(".cadastrosPrincipais .informacoesAdicionaisAluno");

    informacoesAdicionaisAluno.find(".infoMatricula")[0].textContent 				= json.matricula;
    informacoesAdicionaisAluno.find(".infoNome")[0].textContent 						= json.nome +' '+ json.sobrenome;
    informacoesAdicionaisAluno.find(".infoNomePai")[0].textContent 					= json.nomePai;
    informacoesAdicionaisAluno.find(".infoNomeMae")[0].textContent 					= json.nomeMae;
    informacoesAdicionaisAluno.find(".infoDataNascimento")[0].textContent 	= json.dataNascimento;
    informacoesAdicionaisAluno.find(".infoTurma")[0].textContent 						= json.turma;
  },

  mostrarTurmasDisponiveis : function(){
    this.buscarTurma(this.redenrizarComboTurmaComBaseJson);
  },

  redenrizarComboTurmaComBaseJson : function (json){
    var $elComboTurmaAluno = $(".cadastrosPrincipais .inputSerieAluno");
    strOption = "";

    for(var i = 0; i < json.length; i++) {
      strOption += "" +
            "<option>" + json[i] + " </option>" ;
    }
    $elComboTurmaAluno.html(strOption);
  },

  obterDadosDaTelaDeCadastroAluno : function (){
    var matricula = $(".formDadosCadastroAluno .inputMatriculaAluno")[0].value;
    if(matricula != ""){
    	var aluno = {
        matricula : $(".formDadosCadastroAluno .inputMatriculaAluno")[0].value,
    		nome : $(".formDadosCadastroAluno .inputNomeAluno")[0].value,
    		sobrenome : $(".formDadosCadastroAluno .inputSobrenomeAluno")[0].value,
    		nomePai : $(".formDadosCadastroAluno .inputNomePaiAluno")[0].value,
    		nomeMae : $(".formDadosCadastroAluno .inputNomeMaeAluno")[0].value,
    		dataNascimento : $(".formDadosCadastroAluno .inputDataNascimentoAluno")[0].value,
    		email : $(".formDadosCadastroAluno .inputEmailAluno")[0].value,
    		telefone: $(".formDadosCadastroAluno .inputTelefoneAluno")[0].value,
    		turma: $(".formDadosCadastroAluno .inputSerieAluno")[0].value,
    	};
    }else {
      var aluno = {
    		nome : $(".formDadosCadastroAluno .inputNomeAluno")[0].value,
    		sobrenome : $(".formDadosCadastroAluno .inputSobrenomeAluno")[0].value,
    		nomePai : $(".formDadosCadastroAluno .inputNomePaiAluno")[0].value,
    		nomeMae : $(".formDadosCadastroAluno .inputNomeMaeAluno")[0].value,
    		dataNascimento : $(".formDadosCadastroAluno .inputDataNascimentoAluno")[0].value,
    		email : $(".formDadosCadastroAluno .inputEmailAluno")[0].value,
    		telefone: $(".formDadosCadastroAluno .inputTelefoneAluno")[0].value,
    		turma: $(".formDadosCadastroAluno .inputSerieAluno")[0].value,
    	};
    }
    console.log(aluno.dataNascimento);
  	return JSON.stringify(aluno);
  },

  limparTelaCadastroAluno : function(){
  	  $(".formDadosCadastroAluno .inputNomeAluno")[0].value = "";
  		$(".formDadosCadastroAluno .inputSobrenomeAluno")[0].value = "";
  		$(".formDadosCadastroAluno .inputNomePaiAluno")[0].value = "";
  		$(".formDadosCadastroAluno .inputNomeMaeAluno")[0].value = "";
  		$(".formDadosCadastroAluno .inputDataNascimentoAluno")[0].value = "";
  		$(".formDadosCadastroAluno .inputEmailAluno")[0].value = "";
  		$(".formDadosCadastroAluno .inputTelefoneAluno")[0].value = "";
  		$(".formDadosCadastroAluno .inputSerieAluno")[0].value = "";
  	},

    remover : function(btn){
      var matricula = this.getMatricula(btn);
      this.excluirAluno(matricula, function(){
        var aluno = new alunoController();
        aluno.buscarAlunos();
      });
    },

    editarAluno : function(btn){
      var matricula = this.getMatricula(btn);
      this.buscarAlunoPorMatricula(matricula, function(json){
        var aluno = new alunoController();
        aluno.preecherInformacoesEdicao(json);
        aluno.mostrarTurmasDisponiveis();
        $("#modalCadastrarDadosAluno").modal('show');
      })
    },

    preecherInformacoesEdicao : function(json){
      $(".formDadosCadastroAluno .inputMatriculaAluno")[0].value      = json.matricula;
      $(".formDadosCadastroAluno .inputNomeAluno")[0].value           = json.nome;
  		$(".formDadosCadastroAluno .inputSobrenomeAluno")[0].value      = json.sobrenome;
  		$(".formDadosCadastroAluno .inputNomePaiAluno")[0].value        = json.nomePai;
  		$(".formDadosCadastroAluno .inputNomeMaeAluno")[0].value        = json.nomeMae;
  		$(".formDadosCadastroAluno .inputDataNascimentoAluno")[0].value = json.dataNascimento;
  		$(".formDadosCadastroAluno .inputEmailAluno")[0].value          = json.email;
  		$(".formDadosCadastroAluno .inputTelefoneAluno")[0].value       = json.telefone;
  		$(".formDadosCadastroAluno .inputSerieAluno")[0].value          = json.turma;
    }
}
