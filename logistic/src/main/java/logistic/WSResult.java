package logistic;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WSResult {

	private long execTime;
	private String result;
	private ArrayList<String> strArray;

	@XmlElement
	public ArrayList<String> getStrArray() {
		return strArray;
	}

	public void setStrArray(ArrayList<String> strArray) {
		this.strArray = strArray;
	}

	@XmlElement
	public long getExecTime() {
		return this.execTime;
	}

	public void setExecTime(long execTime) {
		this.execTime = execTime;
	}

	@XmlElement
	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
