//$(document).ready(function () {
//	fazAInjecaoDoConteudo();
//})

function fazAInjecaoDoConteudo(localParaInjecao, nomeArquivoInjecao) {

	var $elLocalParaInjecao = localParaInjecao;

	$.get(nomeArquivoInjecao).success(function (html) {
		$elLocalParaInjecao.html(html);
	});
}

var btn_cadastrarDisciplina = $('#btn_cadastrarDisciplina');
btn_cadastrarDisciplina[0].addEventListener("click", OnClick_btn_cadastrarDiciplina);

function OnClick_btn_cadastrarDiciplina(){
	fazAInjecaoDoConteudo($(".conteudo"), "cad_disciplina.html");
}

var btn_cadastrarUsuarios = $('#btn_cadastrarUsuarios');
btn_cadastrarUsuarios[0].addEventListener("click", OnClick_btn_cadastrarUsuarios);

function OnClick_btn_cadastrarUsuarios(){
	fazAInjecaoDoConteudo($(".conteudo"), "cad_aluno.html");
}

var btn_cadastrarTarefas = $('#btn_cadastrarTarefas');
btn_cadastrarTarefas[0].addEventListener("click", OnClick_btn_cadastrarTarefas);

function OnClick_btn_cadastrarTarefas(){
	fazAInjecaoDoConteudo($(".conteudo"), "cad_tarefa.html");
}

var btn_cadastrarNotasFaltas = $('#btn_cadastrarNotasFaltas');
btn_cadastrarNotasFaltas[0].addEventListener("click", OnClick_btn_cadastrarNotasFaltas);

function OnClick_btn_cadastrarNotasFaltas(){
	fazAInjecaoDoConteudo($(".conteudo"), "lancamento_nota.html");
}