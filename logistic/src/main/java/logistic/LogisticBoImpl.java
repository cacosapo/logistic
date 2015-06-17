package logistic;

import java.util.ArrayList;
import java.util.HashMap;


public class LogisticBoImpl implements LogisticBo{

	public String getHelloWorld(){
		return "JAX-WS + Spring!";
	}
	public WSResult getLogistic(){
		HashMap<String, Integer> hashLog = new HashMap<String, Integer>();
		hashLog.put("AB", 10);
		hashLog.put("BD", 15);
		hashLog.put("AC", 20);
		hashLog.put("CD", 30);
		hashLog.put("BE", 50);
		hashLog.put("DE", 30);
		

		ArrayList<String> result = new ArrayList<String>();
		result.add("a");
		result.add("b");
		long start = System.currentTimeMillis();
		WSResult r = new WSResult();
		r.setResult("teste");
		r.setExecTime(System.currentTimeMillis() - start);
		r.setStrArray(result);
		
		return r;
	}
	
}