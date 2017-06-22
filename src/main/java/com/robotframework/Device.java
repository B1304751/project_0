package com.robotframework;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEVICE")
public class Device {

	@Column(name = "PORT")
	private int port;

	@Id
	@Column(name = "DEVICE_NAME")
	private String deviceName;
	
	private static List<String> list = new ArrayList<String>();
	
	public Device() {
		
	}

	public List<String> getAllDeviceName() throws Exception {
		try {
			if (list.size() > 0) {
				return list;
			} else {
				throw new Exception("Empty list device");
			}
		} catch (Exception e) {
			 throw new Exception("Emoty list device");
		}
	}

	public String CreateDevice(String name, int port) {
		try {
			if (name.length() >= 5 && port >= 1000) {
				list.add(name);
				return "[" + name + "/" + port + "]" + " created";
			} else {
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			throw new IllegalArgumentException();
			
		}
	}
	
	public String DeleteDevice(String name, int port) {
      try {
    	  if (name.length() >= 5 && port >= 1000) {
				list.remove(list.indexOf(name));
				return "[" + name + "/" + port + "]" + " deleted";
			} else {
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deviceName == null) ? 0 : deviceName.hashCode());
		result = prime * result + port;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		if (deviceName == null) {
			if (other.deviceName != null)
				return false;
		} else if (!deviceName.equals(other.deviceName))
			return false;
		if (port != other.port)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Device [port=" + getPort() + ", deviceName=" + getDeviceName() + "]";
	}
	
}
