package br.com.myloginapp.model;

enum Natureza {
    RESUMO,
    COMPLETO
}

public class Artigo {

    public static final String naturezaToString(Natureza natureza) {
        // TODO: usar hash para deixar mais manutenível
        String result = "RESUMO";
        switch (natureza) {
            case COMPLETO:
                result = "COMPLETO";
                break;
        }
        return result;
    }
    
    public static final Natureza stringToNatureza(String str) {
        Natureza result = Natureza.RESUMO;
        // TODO: usar hash para deixar mais manutenível
        if (str.equals("COMPLETO")) result = Natureza.COMPLETO;
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
    public Natureza getNatureza() {
        return natureza;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setNatureza(Natureza natureza) {
        this.natureza = natureza;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    private int codigo;
    private String titulo;
    private String autor;
    private String email;
    private Natureza natureza = Natureza.RESUMO;
    private int codigoProjeto;
}
