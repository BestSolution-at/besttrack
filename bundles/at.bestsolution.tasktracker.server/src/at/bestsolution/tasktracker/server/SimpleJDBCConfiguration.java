package at.bestsolution.tasktracker.server;

import java.util.Properties;

import org.osgi.service.component.annotations.Component;
import org.postgresql.Driver;

import at.bestsolution.persistence.java.JDBCConfiguration;
import at.bestsolution.persistence.java.JDBCConnectionProvider;

@Component
public class SimpleJDBCConfiguration implements JDBCConfiguration {
	private String host = "localhost";
	private String password = null;
	private String username = "postgres";

	public SimpleJDBCConfiguration() {
		Properties p = new Properties(); // Activator.getInstance().getProperties();

		host = p.getProperty("db.hostname","localhost");
		password = p.getProperty("db.password",null);
		username = p.getProperty("db.username","postgres");
	}

	@Override
	public String getId() {
		return JDBCConnectionProvider.DEFAULT_CONFIGURATION;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getConnectionURL() {
		return "jdbc:postgresql://"+host+"/task_track";
	}

	@Override
	public Class<?> getJDBCDriver() {
		return Driver.class;
	}

	@Override
	public String getDatabaseType() {
		return "Postgres";
	}

}
