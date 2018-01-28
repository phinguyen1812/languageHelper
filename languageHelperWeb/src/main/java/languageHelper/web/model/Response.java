package languageHelper.web.model;

public class Response {

	// ----------------- propriétés
	// statut de l'opération
	private int status;
	// la réponse JSON
	private Object data;

	// ---------------constructeurs
	public Response() {
	}

	public Response(int status, Object data) {
		this.status = status;
		this.data = data;
	}

	// méthodes
	public void incrStatusBy(int increment) {
		status += increment;
	}

	// ----------------------getters et setters

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}

