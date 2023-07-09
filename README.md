
_Projeto Bibilioteca_

## fazer uma apresenaçãod sobre o projeto na sexta.
## mostrar o funcionamento de alguma parte do código.


_note do projeto_
eu dividir por tï¿½picos para melhor compreensï¿½o
        <status - se tem chamado pronta sim ou nï¿½o >
exemplo *status - se tem chamado pronta sim ou nï¿½o*
    assunto - complemento


        App.java - saï¿½da de arquivos (por enquanto ï¿½ a interface)

#   model
##        aluno *concluido - sem chamada*
            Aluno - ï¿½ a classe que do aluno(atributos)
                nome -
                cpf -
                matricula - 
                endereco - 
                contanto - 

##        emprestimos *falta concluir -  sem chamada*
            Emprestimos - ï¿½ a classe do emprestimos( alteraï¿½ï¿½es pendentes)

            ******* falta alterar ******


##        exemplar *falta iniciar*
            Exemplar - classe de exemplar(falta iniciar chamadas)

                cï¿½digo -
                data_de_compra -
                titulo - 
                disponivel -
                consultar - 
##        hisotrico *Concluido - sem chamadas*
###            <Historico> - ok
responsavel por armazenar da data do historico
###            <ItemHistorico> - ok
ï¿½ a classe que armazena a data e o historico dos livros
pretendo fazer: 
    data_do_ultimo_emprestimo()
    data_de_emprestimo()
    data_de_devoluï¿½ï¿½o()

# pattern 


#  repository *Erro - sem chamadas*
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
*Esse ï¿½ a exceï¿½ï¿½o base, com ela as outras exceï¿½ï¿½es usando super*
*se chamam, ela foi baseada no que o professor fez*  


#   universidade
        BibliotecaException -
##    ?BibLiotecaUniversidade
*Essa classe ï¿½ repsonsavel por criar os arquivo <biblioteca.liv>*
*ela usa a biblioteca de java.io.FIle*

https://github.com/lucasBalmantcoder/projeto_java_biblioteca.git

