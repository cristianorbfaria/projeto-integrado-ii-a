package model;

public class Pergunta {
    
    private int id;
    private String enunciado;
    private int idQuestionario;
    private int idTipoPergunta;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public int getIdQuestionario() {
		return idQuestionario;
	}
	public void setIdQuestionario(int idQuestinario) {
		this.idQuestionario = idQuestinario;
	}
	public int getIdTipoPergunta() {
		return idTipoPergunta;
	}
	public void setIdTipoPergunta(int idTipoPergunta) {
		this.idTipoPergunta = idTipoPergunta;
	}

}
