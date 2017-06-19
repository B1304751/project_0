package com.robotframework;

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
	
	public Device() {
		
	}

	public String getAllDeviceName() {
		try {
			if (getDeviceName() != null && getPort() != 0) {
				return "[" + deviceName + "/" + port + "]";
			} else {
				throw new Exception("Empty device list");
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String CreateDevice(String name, int port) {
		try {
			if (name.length() >= 5 && port >= 1000) {
				this.deviceName = name;
				this.port = port;
				return "[" + name + "/" + port + "]" + " created";
			} else {
				throw new IllegalArgumentException("Invalid type arguments");
			}
		} catch (Exception e) {
			return e.getMessage();
			
		}
	}
	
	public String DeleteDevice(String name, int port) {
      try {
    	  if (name.length() >= 5 && port >= 1000) {
				this.deviceName = name;
				this.port = port;
				return "[" + name + "/" + port + "]" + " deleted";
			} else {
				throw new IllegalArgumentException("Invalid type arguments");
			}
		} catch (Exception e) {
			return e.getMessage();
			
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
