package logistic.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import logistic.LogisticBo;
import logistic.WSResult;

@WebService
public class LogisticWS{

	// DI via Spring
	private LogisticBo logisticBo;
	
	@WebMethod(exclude = true)
	public void setLogisticBo(LogisticBo logisticBo) {
		this.logisticBo = logisticBo;
	}

	@WebMethod(operationName = "getLogistic")
	public WSResult getLogistic(
			@XmlElement(required=true)
			@WebParam(name = "Orig") String orig,
			@XmlElement(required=true)
			@WebParam(name = "dest") String dest,
			@XmlElement(required=true)
			@WebParam(name = "autonomia") Integer autonomia,
			@XmlElement(required=true)
			@WebParam(name = "valorLitro") Double valorLitro
			) {
		System.out.println(orig);
		System.out.println(dest);
		System.out.println(autonomia);
		System.out.println(valorLitro);

		return logisticBo.getLogistic(orig,dest,autonomia,valorLitro);

	}

}