# Projeto Bibilioteca 
<p align=?center?>

## sa�da
    app
        App.java - sa�da de arquivos (por enquanto � a interface)

    model
        aluno
            Aluno - � a classe que do aluno(atributos)
                nome -
                cpf -
                matricula - 
                endereco - 
                contanto - 

        emprestimos 
            Emprestimos - � a classe do emprestimos( altera��es pendentes)

            ******* falta alterar ******


        exemplar 
            Exemplar - classe de exemplar(falta iniciar chamadas)

                c�digo -
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
*Essa classe � repsonsavel por criar os arquivo <biblioteca.liv>*
*ela usa a biblioteca de java.io.FIle*

----------------------------------------------------------------------
### notas - interface - Reposit�rioAluno
----------------------------------------------------------------------

inserir_aluno(Aluno aluno) - insere aluno novo 
alterar_aluno(Aluno aluno) - sem funcinalidade 
deletar_aluno(Aluno aluno) - deleleta dados do aluno
buscar_aluno(String cpf) - busca alunos usando dados de cpf

-------------------------------------------------------------------

-----------------------------------------------------------------------


https://github.com/lucasBalmantcoder/projeto_java_biblioteca.git

