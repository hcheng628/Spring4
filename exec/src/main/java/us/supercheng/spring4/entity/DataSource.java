package us.supercheng.spring4.entity;

import java.util.Properties;

public class DataSource {
	
	private Properties propDB;
	private int dbId;
	
	public DataSource() {
		super();
	}
	
	public DataSource(Properties propDB, int dbId) {
		super();
		this.propDB = propDB;
		this.dbId = dbId;
	}

	public int getDbId() {
		return dbId;
	}

	public void setDbId(int dbId) {
		this.dbId = dbId;
	}

	public Properties getPropDB() {
		return propDB;
	}

	public void setPropDB(Properties propDB) {
		this.propDB = propDB;
	}
	
	@Override
	public String toString() {
		return "DataSource [propDB=" + propDB + ", dbId=" + dbId + "]";
	}
}