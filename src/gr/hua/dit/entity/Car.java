package gr.hua.dit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Car")
@Entity
@Table(name = "car")
public class Car implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4310661683443846471L;

	/**
	 * 
	 */

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "last_date")
	private String lastDate;

	@Column(name = "car_model")
	private String carModel;
	
	@Column(name = "car_type")
	private String carType;
	
	
	public Car() {
		
	}

	public Car(int id, String firstName, String ownerName, String lastDate, String carType) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.lastDate = lastDate;
		this.carModel = carModel;
		this.carType = carType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	
	@Override
	public String toString() {
		return "Car [id=" + id + ", ownerName=" + ownerName + ", lastDate=" + lastDate + ", carModel=" + carModel + ", carType=" + carType + "]";
	}
	
	

}
