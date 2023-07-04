
_Projeto Bibilioteca_

_note do projeto_
eu dividir por t�picos para melhor compreens�o
        <status - se tem chamado pronta sim ou n�o >
exemplo *status - se tem chamado pronta sim ou n�o*
    assunto - complemento

# sa�da
    app
        App.java - sa�da de arquivos (por enquanto � a interface)

#   model
##        aluno *concluido - sem chamada*
            Aluno - � a classe que do aluno(atributos)
                nome -
                cpf -
                matricula - 
                endereco - 
                contanto - 

##        emprestimos *falta concluir -  sem chamada*
            Emprestimos - � a classe do emprestimos( altera��es pendentes)

            ******* falta alterar ******


##        exemplar *falta iniciar*
            Exemplar - classe de exemplar(falta iniciar chamadas)

                c�digo -
                data_de_compra -
                titulo - 
                disponivel -
                consultar - 

#  repository 
##      aluno
            AlunoNaoCadastradoException - 
            CPFJAcadastradoException - 
###       ? RepositorioAluno -
inserir_aluno(Aluno aluno) - insere aluno novo 
alterar_aluno(Aluno aluno) - sem funcinalidade 
deletar_aluno(Aluno aluno) - deleleta dados do aluno
buscar_aluno(String cpf) - busca alunos usando dados de cpf

-------------------------------------------------------------------

            RepositorioAlunoLista 
###     RepositorioException - ****exception base****
*Esse � a exce��o base, com ela as outras exce��es usando super*
*se chamam, ela foi baseada no que o professor fez*  


#   universidade
        BibliotecaException -
##    ?BibLiotecaUniversidade
*Essa classe � repsonsavel por criar os arquivo <biblioteca.liv>*
*ela usa a biblioteca de java.io.FIle*


https://github.com/lucasBalmantcoder/projeto_java_biblioteca.git
