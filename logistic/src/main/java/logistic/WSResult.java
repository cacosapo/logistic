package logistic;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WSResult {

	private Double custo;
	private List<String> path;

	@XmlElement
	public List<String> getPath() {
		return path;
	}

	public void setPath(List<String> path) {
		this.path = path;
	}

	@XmlElement
	public Double getCusto() {
		return this.custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

}
