//package com.trilogy.motorcycleservice.dao;
//
//import com.trilogy.motorcycleservice.model.Motorcycle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
//public class MotorcycleDaoJdbcTemplateImpl implements MotorcycleDao {
//    private final static String CREATE_MOTORCYCLE_SQL = "INSERT INTO motorcycle (price, vin, make, model, year, color) VALUES (?,?,?,?,?,?)";
//    private final static String READ_MOTORCYCLE_SQL = "SELECT * FROM motorcycle WHERE motorcycle_id = ?";
//    private final static String GET_ALL_MOTORCYCLES_SQL = "SELECT * FROM motorcycle";
//    private final static String UPDATE_MOTORCYCLE_SQL = "UPDATE motorcycle SET price = ?, vin = ?, make = ?, model = ?, year = ?, color = ? WHERE motorcycle_id = ?";
//    private final static String DELETE_MOTORCYCLE_SQL = "DELETE FROM motorcycle WHERE motorcycle_id = ?";
//
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public MotorcycleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}
//
//
//    @Override
//    public Motorcycle createMotorcycle(Motorcycle motorcycle) {
//        jdbcTemplate.update(CREATE_MOTORCYCLE_SQL, motorcycle.getPrice(), motorcycle.getVin(), motorcycle.getMake(), motorcycle.getModel(), motorcycle.getYear(), motorcycle.getColor());
//        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
//        motorcycle.setMotorcycleId(id);
//        return motorcycle;
//    }
//
//    @Override
//    public Motorcycle readMotorcycle(int id) {
//        try{
//            return jdbcTemplate.queryForObject(READ_MOTORCYCLE_SQL, this::mapRowToMotorcycle, id);
//        } catch (EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
//
//    @Override
//    public List<Motorcycle> getAllMotorcycle() {
//        return jdbcTemplate.query(GET_ALL_MOTORCYCLES_SQL, this::mapRowToMotorcycle);
//    }
//
//    @Override
//    public void updateMotorcycle(Motorcycle motorcycle) {
//        jdbcTemplate.update(UPDATE_MOTORCYCLE_SQL,motorcycle.getPrice(),motorcycle.getVin(), motorcycle.getMake(), motorcycle.getModel(), motorcycle.getYear(), motorcycle.getColor(), motorcycle.getMotorcycleId());
//
//    }
//
//    @Override
//    public void deleteMotorcycle(int id) {
//        jdbcTemplate.update(DELETE_MOTORCYCLE_SQL,id);
//    }
//
//    public Motorcycle mapRowToMotorcycle(ResultSet rs, int rowNum) throws SQLException {
//        Motorcycle motorcycle = new Motorcycle();
//        motorcycle.setMotorcycleId(rs.getInt("motorcycleId"));
//        motorcycle.setPrice(rs.getBigDecimal("price"));
//        motorcycle.setVin(rs.getString("vin"));
//        motorcycle.setMake(rs.getString("make"));
//        motorcycle.setModel(rs.getString("model"));
//        motorcycle.setYear(rs.getString("year"));
//        motorcycle.setColor(rs.getString("color"));
//        return motorcycle;
//    }
//}
