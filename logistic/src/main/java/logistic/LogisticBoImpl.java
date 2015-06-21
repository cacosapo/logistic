package logistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import logistic.utils.DijkstraAlgorithm;
import logistic.utils.Edge;
import logistic.utils.Graph;
import logistic.utils.Vertex;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.mkyong.common.Lane;
import com.mkyong.persistence.LaneDaoInterface;

@Service
public class LogisticBoImpl extends SpringBeanAutowiringSupport implements LogisticBo {

	@Autowired
	private LogisticBo logisticBo;
	@Autowired
	private LaneDaoInterface lanedao;
	
	private List<Vertex> nodes;
	private List<Edge> edges;

	public WSResult getLogistic(String orig,String dest,
			Integer autonomia,
			Double valorLitro
			){
		// Bug Fix WS is not autowiring
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		
		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		
		// Populate data from database
		lanedao.openCurrentSession();
		List<String> vertexList = lanedao.vertexList();
		for (String string : vertexList) {
			Vertex location = new Vertex(string, string);
			nodes.add(location);
		}
		lanedao.closeCurrentSession();
		
		lanedao.openCurrentSession();
		List<Lane> laneList = lanedao.findAll();
		for (Lane lane : laneList) {
			addLane(lane.getLaneId(),
					new Vertex(lane.getSource(), lane.getSource()), new Vertex(
							lane.getDestination(), lane.getDestination()),
					lane.getWeigth());
		}
		lanedao.closeCurrentSession();
		Vertex origVert = new Vertex(orig, orig);
		Vertex destVert = new Vertex(dest, dest);
		Graph graph = new Graph(nodes, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(origVert);
		LinkedList<Vertex> path = dijkstra.getPath(destVert);
		System.out.println(dijkstra.getDistance());
		Double dist = new Double(dijkstra.getDistance().get(destVert));
		System.out.println(path);

		WSResult r = new WSResult();
		ArrayList<String> resultList = new ArrayList<String>();
		for (Vertex vertex : path) {
			resultList.add(vertex.getId());
		}
		r.setPath(resultList);
		r.setCusto((dist/autonomia)*valorLitro);
//		r.setCusto(dijkstra.getDistance().get(dest));
//		r.setStrArray(result);
		
		return r;
	}
	
	private void addLane(String laneId, int sourceLocNo, int destLocNo,
			int duration) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo),
				nodes.get(destLocNo), duration);
		edges.add(lane);
	}
	
	private void addLane(String laneId, Vertex source, Vertex destination,
			int duration) {
		Edge lane = new Edge(laneId, source,
				destination, duration);
		edges.add(lane);
	}
	
}