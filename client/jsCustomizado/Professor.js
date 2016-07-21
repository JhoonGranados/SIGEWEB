function professorController(){

}

professorController.prototype = {
  buscarProfessores : function(){
    var url = "http://localhost:8081/professor/buscar";
    var requestType = "GET";
    this.realizarRequest(requestType, url, renderizarTabelaProfessorComBaseJson, "");
  },

  buscarProfessorPorMatricula : function(matricula, acao){
    var url = "http://localhost:8081/professor/buscar/"+matricula;
    var requestType = "GET";
    this.realizarRequest(requestType, url, acao, "");
  },

  buscarMaterias : function(acao){
    var url = "http://localhost:8081/materia/buscarMaterias";
    var requestType = "GET";
    this.realizarRequest(requestType, url, acao, "");
  },

  salvarProfessor : function(acao){
    url = "http://localhost:8081/professor/salvar";
    requestType = "POST";
    dataType = this.obterDadosDaTelaDeCadastroProfessor();
    this.realizarRequest(requestType, url, acao, dataType)
  },

  excluirProfessor : function(matricula, acao){
    url = "http://localhost:8081/professor/remove/" + matricula;
    requestType = "DELETE";
    this.realizarRequest(requestType, url, acao, "");
  },

  realizarRequest : function(requestType, url, acao, valores){
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

  getMatricula : function(e){
      var tr = e.closest("tr");
      var tds = tr.getElementsByTagName('td');
      var matricula = tds[1].textContent;
      return matricula;
  },

  mostrarInformacoesAdicionaisProfessor : function(btn){
    var matricula = this.getMatricula(btn);
    this.buscarProfessorPorMatricula(matricula, this.preencherInformacoesProfessor);
  },

  preencherInformacoesProfessor : function(json){

  	var informacoesAdicionaisprofessor = $(".cadastrosPrincipais .informacoesAdicionaisProfessor");

  	informacoesAdicionaisprofessor.find(".infoMatricula")[0].textContent 					= json.matricula;
  	informacoesAdicionaisprofessor.find(".infoNome")[0].textContent 							= json.nome +' '+ json.sobrenome;
  	informacoesAdicionaisprofessor.find(".infoCpf")[0].textContent 								= json.cpf;
  	informacoesAdicionaisprofessor.find(".infoMateriaMinistrada")[0].textContent 	= json.materia;
  	informacoesAdicionaisprofessor.find(".infoDataNascimento")[0].textContent 		= json.dataNascimento;
  	informacoesAdicionaisprofessor.find(".infoTelefone")[0].textContent 					= json.telefone
  	informacoesAdicionaisprofessor.find(".infoEmail")[0].textContent 							= json.email;
  },

  mostrarMateriasDisponiveis : function(){
    this.buscarMaterias(this.renderizarComboComBasejson);
  },

  renderizarComboComBasejson : function(json){
    var $elComboMateriasProfessor = $(".cadastrosPrincipais .inputMateriaProfessor");
    strOption = "";

    for(var i = 0; i < json.length; i++) {
      strOption += "" +
            "<option>" + json[i] + " </option>" ;
    }
    $elComboMateriasProfessor.html(strOption);
  },

  obterDadosDaTelaDeCadastroProfessor : function(){
  	var professor = {
  		nome : $(".formDadosCadastroProfessor .inputNomeProfessor")[0].value,
  		sobrenome : $(".formDadosCadastroProfessor .inputSobrenomeProfessor")[0].value,
  		cpf : $(".formDadosCadastroProfessor .inputCpfProfessor")[0].value,
  		materia : $(".formDadosCadastroProfessor .inputMateriaProfessor")[0].value,
  		dataNascimento : $(".formDadosCadastroProfessor .inputDataNascimentoProfessor")[0].value,
  		email : $(".formDadosCadastroProfessor .inputEmailProfessor")[0].value,
  		telefone: $(".formDadosCadastroProfessor .inputTelefoneProfessor")[0].value,
  	};
  	return JSON.stringify(professor);
  },

  limparDadosCadastroProfessor : function(){
    var form = $(".formDadosCadastroProfessor");
    form[0].reset();
  },

  remover : function(btn){
    var matricula = this.getMatricula(btn);
    this.excluirProfessor(matricula, function(){
      var professor = new professorController();
      professor.buscarProfessores();
    });
  }
}
