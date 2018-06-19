package br.com.devmedia.bean;

import br.com.devmedia.model.Contato;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

//Este annotation é necessário para que o formulário possa fazer chamadas à métodos desta classe.
//O atributo name server para dar-lhe um nome, o qual será usado nos formulários web para acessar dados nesta classe.
@ManagedBean(name = "contatoBean")
//Este annotation define o tipo de sessão para ViewScoped, ou seja, a sessão permanece enquanto o formulário permanecer aberto e toda requisição será uma nova sessão.
@ViewScoped
public class ContatoBean implements Serializable {

    //lista para armazenar os dados (apenas para simular um "banco de dados")
    private static final List<Contato> dados = new ArrayList<>();

    //atributo que receberá os dados digitados nos campos
    private Contato contato;

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    //ao criar a Bean, um novo Contato é instanciado. Isso acontece toda vez que o formulário é carregado. 
    //Isso acontece devido ao tipo de sessão ser ViewScoped
    public ContatoBean() {
        contato = new Contato();
        System.out.println("!");
    }

    //Na página, ao clicar em salvar, este método é acionado. Os valores já estão no atributo contato, basta adicioná-lo à lista.
    public void inserir() {
        dados.add(contato);
        contato = new Contato();
    }

    public void deletar(Contato contato) {
        dados.remove(contato);
    }

    public List<Contato> getContatos() {
        return dados;
    }
}
