# Projeto Bibilioteca 
<p align=?center?>

## saída
    app
        App.java - saída de arquivos (por enquanto é a interface)

    model
        aluno
            Aluno - é a classe que do aluno(atributos)
                nome -
                cpf -
                matricula - 
                endereco - 
                contanto - 

        emprestimos 
            Emprestimos - é a classe do emprestimos( alterações pendentes)

            ******* falta alterar ******


        exemplar 
            Exemplar - classe de exemplar(falta iniciar chamadas)

                código -
                data_de_compra -
                titulo - 
                disponivel -
                consultar - 

    repository 
        aluno
            AlunoNaoCadastradoException - 
            CPFJAcadastradoException - 
           ? RepositorioAluno -
###          RepositorioAlunoLista 

        RepositorioException - ****exception base****
    

    universidade
        BibliotecaException -
###        ?BibLiotecaUniversidade :
*Essa classe é repsonsavel por criar os arquivo <biblioteca.liv>*
*ela usa a biblioteca de java.io.FIle*

----------------------------------------------------------------------
### notas - interface - RepositórioAluno
----------------------------------------------------------------------

inserir_aluno(Aluno aluno) - insere aluno novo 
alterar_aluno(Aluno aluno) - sem funcinalidade 
deletar_aluno(Aluno aluno) - deleleta dados do aluno
buscar_aluno(String cpf) - busca alunos usando dados de cpf

-------------------------------------------------------------------

-----------------------------------------------------------------------


https://github.com/lucasBalmantcoder/projeto_java_biblioteca.git

