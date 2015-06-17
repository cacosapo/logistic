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
			@WebParam(name = "inputString") String inputString) {
		System.out.println(inputString);

		ArrayList<String> result = new ArrayList<String>();
		result.add("a");
		result.add("b");
		long start = System.currentTimeMillis();
		WSResult r = new WSResult();
		r.setResult("result");
		r.setExecTime(System.currentTimeMillis() - start);
		r.setStrArray(result);
		// return logisticBo.getLogistic();
		return r;

	}

}