package com.data.schedular;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.InfluxDBIOException;
import org.influxdb.dto.Pong;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class Schedular {
	
	@Scheduled(cron ="0/10 * * * * ?")
	public void datatranfer() {
		

	
		
		System.out.println("Shedular rumming"+connectDatabase());
	    InfluxDB connection = connectDatabase();
		System.out.println("Shedular rumming"+pingServer(connection));
		whenDatabaseCreatedDatabaseChecksOk();
		
		
	}
	
	
    private InfluxDB connectDatabase() {

        // Connect to database assumed on localhost with default credentials.
        return  InfluxDBFactory.connect("http://127.0.0.1:8086", "admindth", "adminfg");

    }
    
    private boolean pingServer(InfluxDB influxDB) {
        try {
            // Ping and check for version string
            Pong response = influxDB.ping();
            if (response.getVersion().equalsIgnoreCase("unknown")) {
            	System.out.println("Error pinging server.");
                return false;
            } else {
            	System.out.println("Database version: {}"+ response.getVersion());
                return true;
            }
        } catch (InfluxDBIOException idbo) {
        	System.out.println("Exception while pinging database: "+ idbo);
            return false;
        }
    }
    
    public void whenDatabaseCreatedDatabaseChecksOk() {

        InfluxDB connection = connectDatabase();

        // Create "baeldung" and check for it
        connection.createDatabase("baeldung");
        System.out.println("is it true :::"+connection.databaseExists("baeldung"));

        // Verify that nonsense databases are not there
     	System.out.println( connection.databaseExists("foobar"));

        // Drop "baeldung" and check again
        connection.deleteDatabase("baeldung");
     	System.out.println(connection.databaseExists("baeldung"));
    }

}
