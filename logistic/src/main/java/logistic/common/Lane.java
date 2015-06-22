package logistic.common;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "lane", catalog = "logistic")
public class Lane implements java.io.Serializable{
    @Id
    private String laneId;
    private String source;
    private String destination;
    private Integer weigth;
    
    @Id
	@Column(name = "LANE_ID", unique = true, nullable = false)
	public String getLaneId() {
		return laneId;
	}
	public void setLaneId(String laneId) {
		this.laneId = laneId;
	}
	
	@Column(name = "SOURCE", nullable = false, length = 10)
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	@Column(name = "DEST", nullable = false, length = 10)
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	@Column(name = "WEIGHT", nullable = false, length = 10)
	public Integer getWeigth() {
		return weigth;
	}
	public void setWeigth(Integer weigth) {
		this.weigth = weigth;
	}    

}
