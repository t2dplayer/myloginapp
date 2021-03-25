package br.com.myloginapp.model;

enum Situacao {
    DESENVOLVIMENTO,
    DEFENDIDO,
    ABANDONADO
}

public class TCC {

    public static final String situacaoToString(Situacao situacao) {
        // TODO: usar hash para deixar mais manutenível
        String result = "DESENVOLVIMENTO";
        switch (situacao) {
            case DEFENDIDO:
                result = "DEFENDIDO";
                break;
            case ABANDONADO:
                result = "ABANDONADO";
                break;
        }
        return result;
    }
    
    public static final Situacao stringToSituacao(String str) {
        Situacao result = Situacao.DESENVOLVIMENTO;
        // TODO: usar hash para deixar mais manutenível
        if (str.equals("DEFENDIDO")) result = Situacao.DEFENDIDO;
        else if (str.equals("ABANDONADO")) result = Situacao.ABANDONADO;
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the situacao
     */
    public Situacao getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the codigoProjeto
     */
    public int getCodigoProjeto() {
        return codigoProjeto;
    }

    /**
     * @param codigoProjeto the codigoProjeto to set
     */
    public void setCodigoProjeto(int codigoProjeto) {
        this.codigoProjeto = codigoProjeto;
    }
    private int codigo;
    private String titulo;
    private String autor;
    private Situacao situacao = Situacao.DESENVOLVIMENTO;
    private int codigoProjeto;
}
