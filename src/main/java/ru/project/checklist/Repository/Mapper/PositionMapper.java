package ru.project.checklist.Repository.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.project.checklist.Entity.Position;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PositionMapper implements RowMapper<Position> {

    @Override
    public Position mapRow(ResultSet resultSet, int i) throws SQLException {
        Position position=new Position();
        position.setId(resultSet.getInt("id"));
        position.setName(resultSet.getString("name"));
        return position;
    }
}
