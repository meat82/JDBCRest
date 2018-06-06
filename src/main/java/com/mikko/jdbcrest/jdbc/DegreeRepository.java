package com.mikko.jdbcrest.jdbc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DegreeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Add new thermal
	public void addDegree(double value) {

		Map<String, Object> query = jdbcTemplate.queryForMap("SELECT count(*) FROM production.thermal");
		
		Object size = query.get("count(*)");
		if(size != null && size instanceof Long){
			if(((Long) size).longValue() > 10) {
				System.out.println("now is time to delete record before add!");
				jdbcTemplate.update("DELETE FROM production.thermal ORDER BY THERMAL_ID ASC LIMIT 1");
			}
		}
		
		jdbcTemplate.update("INSERT INTO production.thermal(DEGREE) VALUES (?)", value);

	}
}
