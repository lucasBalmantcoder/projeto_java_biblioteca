_Projeto Bibilioteca_

_note do projeto_
eu dividir por tópicos para melhor compreensão
        <status - se tem chamado pronta sim ou não >
exemplo *status - se tem chamado pronta sim ou não*
    assunto - complemento

# saída
    app
        App.java - saída de arquivos (por enquanto é a interface)

#   model
##        aluno *concluido - sem chamada*
            Aluno - é a classe que do aluno(atributos)
                nome -
                cpf -
                matricula - 
                endereco - 
                contanto - 

##        emprestimos *falta concluir -  sem chamada*
            Emprestimos - é a classe do emprestimos( alterações pendentes)

            ******* falta alterar ******


##        exemplar *falta iniciar*
            Exemplar - classe de exemplar(falta iniciar chamadas)

                código -
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
*Esse é a exceção base, com ela as outras exceções usando super*
*se chamam, ela foi baseada no que o professor fez*  


#   universidade
        BibliotecaException -
##    ?BibLiotecaUniversidade
*Essa classe é repsonsavel por criar os arquivo <biblioteca.liv>*
*ela usa a biblioteca de java.io.FIle*


https://github.com/lucasBalmantcoder/projeto_java_biblioteca.git

