package logistic;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService
public class LogisticWS{

	// DI via Spring
	private LogisticBo logisticBo;
	
	
	@PostConstruct
	public void initIt() throws Exception {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	@WebMethod(exclude = true)
	public void setLogisticBo(LogisticBo logisticBo) {
		this.logisticBo = logisticBo;
	}

	@WebMethod(operationName = "getLogistic")
	public WSResult getLogistic(
			@WebParam(name = "Orig") String orig,
			@WebParam(name = "dest") String dest,
			@WebParam(name = "autonomia") String autonomia,
			@WebParam(name = "valorLitro") String valorLitro
			) {
		System.out.println(orig);
		System.out.println(dest);
		System.out.println(autonomia);
		System.out.println(valorLitro);

		return logisticBo.getLogistic(orig,dest,autonomia,valorLitro);

	}

}