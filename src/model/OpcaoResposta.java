package model;

public class OpcaoResposta {
	
    private int id;
    private String descricao;
    private int idPergunta;
	
    public int getId() {
		return id;
	}
    
	public void setId(int id) {
		this.id = id;
	}

	public int getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(int idPergunta) {
		this.idPergunta = idPergunta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
}
