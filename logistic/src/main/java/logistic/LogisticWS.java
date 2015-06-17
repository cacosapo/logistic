package logistic;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class LogisticWS {

	// DI via Spring
	LogisticBo logisticBo;

	@WebMethod(exclude = true)
	public void setLogisticBo(LogisticBo logisticBo) {
		this.logisticBo = logisticBo;
	}

	@WebMethod(operationName = "getLogistic")
	public WSResult getLogistic(
			@WebParam(name = "origDest") String origDest,
			@WebParam(name = "autonomia") String autonomia,
			@WebParam(name = "valorLitro") String valorLitro
			) {
		System.out.println(origDest);
		System.out.println(autonomia);
		System.out.println(valorLitro);

		return logisticBo.getLogistic();

	}

}