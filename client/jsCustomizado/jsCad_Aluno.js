
var btnPesquisarDados = $(".cadastrosPrincipais .btnPesquisarDados");
var btnSalvarAluno = $(".cadastrosPrincipais .btnSalvarAluno");
var btnPreencherTurmaAluno = $(".cadastrosPrincipais .btnPreencherTurmaAluno");

var btnPreencherTurmaProfessor = $('.cadastrosPrincipais .btnPreencherTurmaProfessor');
var btnSalvarProfessor = $('.cadastrosPrincipais .btnSalvarProfessor');

btnPesquisarDados[0].addEventListener("click", realizarPesquisa);
btnSalvarAluno[0].addEventListener("click", cadastrarAlunos);
btnPreencherTurmaAluno[0].addEventListener("click", preecherTurmas);

btnPreencherTurmaProfessor[0].addEventListener("click", preencherMaterias);
btnSalvarProfessor[0].addEventListener("click", cadastrarProfessor)

function renderizarTabelaProfessorComBaseJson(json){
	var $elTabelaProfessor = $(".cadastrosPrincipais .tableProfessor tbody");
	var strTBody = "";

	for(var i=0; i<json.length;i++){
		strTBody +=""+
		"<tr>" +
      		"<td>" + " " + " </td>" +
      		"<td>" + json[i].matricula + "</td>" +
	        "<td>" + json[i].nome + " </td>" +
	        "<td>" + json[i].sobrenome + " </td>" +
	        "<td>" + json[i].materia + " </td>" +
			'<td><button type="button" style="width: 100px" onclick="mostrarInformacoesAdicionaisProfessor(this)" '+
      'class="btn btn-info" data-target="#modalApresentarDadosProfessor" data-toggle="modal">Visualizar</button>'+
			'&nbsp;&nbsp;<button type="button" style="width: 100px" class="btn btn-danger" onclick="removerProfessor(this)">Excluir</button></td>'
	    "<tr>";
	}

	$elTabelaProfessor.html(strTBody);
}

function renderizarTabelaAlunoComBaseJson(json){
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
	        '&nbsp;&nbsp;<button type="button" style="width: 100px" class="btn btn-danger" onclick="removerAluno(this)">Excluir</button>'+
					'&nbsp;&nbsp;<button type="button" style="width: 100px" class="btn btn-warning" onclick="editarAluno(this)">Editar</button></td>'
	    "<tr>";
	}

	$elTabelaAluno.html(strTBody);
}

function preecherTurmas(){
  var aluno = new alunoController();
  aluno.mostrarTurmasDisponiveis();
}

function preencherMaterias(){
	var professor = new professorController();
	professor.mostrarMateriasDisponiveis();
}

function removerAluno(btn){
  var aluno = new alunoController();
  aluno.remover(btn);
	confirmarSucesso("Aluno Removido Com Sucesso");
}

function editarAluno(btn){
	var aluno = new alunoController();
	aluno.editarAluno(btn);
	confirmarSucesso("Aluno Alterado Com sucesso");
}

function removerProfessor(btn){
	var professor = new professorController();
	professor.remover(btn);
	confirmarSucesso("Professor Removido Com Sucesso");
}

function realizarPesquisa(){

	var _comboSelecao = $(".cadastrosPrincipais #basicSelect");
	var filtroPesquisa = $(".inputFiltroPesquisa");

	if(_comboSelecao[0].selectedIndex == 0){
		var aluno = new alunoController();
		if(filtroPesquisa[0].value != ""){
				aluno.buscarAlunosFiltro(filtroPesquisa[0].value);
		}else{
				aluno.buscarAlunos();
		}
    mostrarTabelaAluno();
	}

	else if(_comboSelecao[0].selectedIndex == 1){
    var professor = new professorController();

    professor.buscarProfessores();
    mostrarTabelaProfessor();
	}
}

function mostrarTabelaProfessor(){
	$('.cadastrosPrincipais #boxPesquisarProfessor').css('display', 'block');
	$('.cadastrosPrincipais #boxPesquisarAlunos').css('display', 'none');
}

function mostrarTabelaAluno(){
	$('.cadastrosPrincipais #boxPesquisarAlunos').css('display', 'block');
	$('.cadastrosPrincipais #boxPesquisarProfessor').css('display', 'none');
}

function mostrarInformacoesAdicionaisAluno(btn){
  var aluno = new alunoController();
  aluno.mostrarInformacoesAdicionaisAluno(btn)
}

function mostrarInformacoesAdicionaisProfessor(btn){
  var professor = new professorController();
  professor.mostrarInformacoesAdicionaisProfessor(btn);
}

function cadastrarAlunos(){
  var aluno = new alunoController();

	var matricula = $(".formDadosCadastroAluno .inputMatriculaAluno")[0].value;

	if(matricula == ""){

		  aluno.salvarAluno(function(){
				var alunoF = new alunoController();
				alunoF.buscarAlunos();
			});
	}else if(matricula != ""){
		aluno.alterarAluno(function(){
			var alunoF = new alunoController();
			alunoF.buscarAlunos();
		});
	}

	aluno.limparTelaCadastroAluno();
	$('#modalCadastrarDadosAluno').modal('hide');
	confirmarSucesso("Aluno Salvo Com Sucesso");
}

function cadastrarProfessor(){
	var professor = new professorController();
	professor.salvarProfessor(function(){
		professorF = new professorController();
		professorF.buscarProfessores();
	});
	professor.limparDadosCadastroProfessor();
	$('#modalCadastrarDadosProfessor').modal('hide');
	confirmarSucesso("Professor Salvo Com Sucesso");
}

function obterDadosDaTelaDeCadastroAluno(){
	var aluno = {
		nome : $(".formDadosCadastroAluno .inputNomeAluno")[0].value,
		sobrenome : $(".formDadosCadastroAluno .inputSobrenomeAluno")[0].value,
		nomePai : $(".formDadosCadastroAluno .inputNomePaiAluno")[0].value,
		nomeMae : $(".formDadosCadastroAluno .inputNomeMaeAluno")[0].value,
		dataNascimento : $(".formDadosCadastroAluno .inputDataNascimentoAluno")[0].value,
		email : $(".formDadosCadastroAluno .inputEmailAluno")[0].value,
		telefone: $(".formDadosCadastroAluno .inputTelefoneAluno")[0].value,
		serie: $(".formDadosCadastroAluno .inputSerieAluno")[0].value,
	};
	return JSON.stringify(aluno);
	}

	function confirmarSucesso(mensagem){
			$('.avisoSucesso')[0].textContent = mensagem;
			$('.avisoSucesso').css('display', 'block');
			setTimeout(function () {$('.avisoSucesso').css('display', 'none');}, 3000);
	}
