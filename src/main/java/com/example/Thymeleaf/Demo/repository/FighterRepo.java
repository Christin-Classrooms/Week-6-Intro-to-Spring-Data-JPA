package com.example.Thymeleaf.Demo.repository;


import com.example.Thymeleaf.Demo.Model.Fighter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FighterRepo {
    
    private final JdbcTemplate jdbcTemplate;


    public FighterRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Fighter fighter){

        String sql = "insert into Fighters (name, health, damage, resistance) values(?,?,?,?)";
        jdbcTemplate.update(sql, fighter.getName(),
                                fighter.getHealth(),
                                fighter.getDamage(),
                                fighter.getResistance());


    }


    public List<Fighter> findAll(){


        String sql = "Select * from Fighters";

        RowMapper<Fighter> mapper = new RowMapper<Fighter>() {
            @Override
            public Fighter mapRow(ResultSet rs, int rowNum) throws SQLException {

                Fighter fighter = new Fighter();
                fighter.setId(rs.getInt("id"));
                fighter.setName(rs.getString("name"));
                fighter.setHealth(rs.getInt("health"));
                fighter.setDamage(rs.getDouble("damage"));
                fighter.setResistance(rs.getDouble("resistance"));

                return fighter;
            }
        };


        return jdbcTemplate.query(sql, mapper);


    }


    public Fighter findById(int id){

        String sql = "Select * from Fighters where id = ?";

        RowMapper<Fighter> mapper = new RowMapper<Fighter>() {
            @Override
            public Fighter mapRow(ResultSet rs, int rowNum) throws SQLException {

                Fighter fighter = new Fighter();

                fighter.setId(rs.getInt("id"));
                fighter.setName(rs.getString("name"));
                fighter.setHealth(rs.getInt("health"));
                fighter.setDamage(rs.getDouble("damage"));
                fighter.setResistance(rs.getDouble("resistance"));
           

                return fighter;
            }
        };

        List<Fighter> results = jdbcTemplate.query(sql, mapper, id);

        return results.isEmpty() ? null : results.get(0);
    
    }

    public Fighter deleteById(int id){
        String sql = "Select * from Fighters where id = ?";

        RowMapper<Fighter> mapper = new RowMapper<Fighter>() {
            @Override
            public Fighter mapRow(ResultSet rs, int rowNum) throws SQLException {

                Fighter fighter = new Fighter();

                fighter.setId(rs.getInt("id"));
                fighter.setName(rs.getString("name"));
                fighter.setHealth(rs.getInt("health"));
                fighter.setDamage(rs.getDouble("damage"));
                fighter.setResistance(rs.getDouble("resistance"));
           

                return fighter;
            }
        };

        List<Fighter> results = jdbcTemplate.query(sql, mapper, id);
        if( results.isEmpty()){ 
            return null; 
        }
        Fighter toDelete = results.get(0);

        String deleteSql = " DELETE FROM Fighters Where id = ?";
        jdbcTemplate.update(deleteSql, id ); 
        return toDelete;
    }

    public long count(){
        String sql = "SELECT COUNT(*) FROM Fighters"; 
        return jdbcTemplate.queryForObject(sql, Long.class);
       

    }

    public boolean existsById(int id){ 
        String sql = "Select COUNT(*) FROM Fighters WHERE id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id); 
        return count != null && count > 0;


    }
}