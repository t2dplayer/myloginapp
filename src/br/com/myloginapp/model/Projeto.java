/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myloginapp.model;
import java.sql.Timestamp;

enum SituacaoProjeto {
    ANDAMENTO,
    CANCELADO,
    FINALIZADO
}

public class Projeto {

    /**
     * @return the situacao
     */
    public SituacaoProjeto getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(SituacaoProjeto situacao) {
        this.situacao = situacao;
    }

    public static final SituacaoProjeto stringToSituacao(String strSituacao) {
        SituacaoProjeto result = SituacaoProjeto.ANDAMENTO;
        if (strSituacao.equals("CANCELADO")) {
            result = SituacaoProjeto.CANCELADO;
        } else if (strSituacao.equals("FINALIZADO")) {
            result = SituacaoProjeto.FINALIZADO;
        }
        return result;
    }
    
    public static final String situacaoToString(SituacaoProjeto situacao) {
        String result = "ANDAMENTO";
        switch (situacao) {
            case CANCELADO:
                result = "CANCELADO";
                break;
            case FINALIZADO:
                result = "FINALIZADO";
                break;
        }
        return result;
    }
    
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nomeProjeto
     */
    public String getNomeProjeto() {
        return nomeProjeto;
    }

    /**
     * @param nomeProjeto the nomeProjeto to set
     */
    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    /**
     * @return the nomeResposavel
     */
    public String getNomeResposavel() {
        return nomeResposavel;
    }

    /**
     * @param nomeResposavel the nomeResposavel to set
     */
    public void setNomeResposavel(String nomeResposavel) {
        this.nomeResposavel = nomeResposavel;
    }

    /**
     * @return the emailResponsavel
     */
    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    /**
     * @param emailResponsavel the emailResponsavel to set
     */
    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }

    /**
     * @return the dataInicio
     */
    public Timestamp getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Timestamp getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Timestamp dataFim) {
        this.dataFim = dataFim;
    }
    private int codigo;
    private String nomeProjeto;
    private String nomeResposavel;
    private String emailResponsavel;
    private Timestamp dataInicio;
    private Timestamp dataFim;
    private SituacaoProjeto situacao;
}
