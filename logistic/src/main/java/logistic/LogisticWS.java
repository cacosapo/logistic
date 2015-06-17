package logistic;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class LogisticWS{

	//DI via Spring
	LogisticBo logisticBo;

	@WebMethod(exclude=true)
	public void setLogisticBo(LogisticBo logisticBo) {
		this.logisticBo = logisticBo;
	}

	@WebMethod(operationName="getLogistic")
	public String getLogistic() {
		
		return logisticBo.getLogistic();
		
	}
 
}