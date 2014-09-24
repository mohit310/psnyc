package org.psnyc.core.dao.mapper;

import org.psnyc.core.authentication.User;
import org.psnyc.data.Field;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mk on 9/23/14.
 */
public class FieldMapper implements ResultSetMapper<Field> {

    @Override
    public Field map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Field field = new Field();
        field.setCountry(resultSet.getString("country"));
        field.setState(resultSet.getString("state"));
        field.setCity(resultSet.getString("city"));
        field.setBurough(resultSet.getString("borough"));
        field.setName(resultSet.getString("name"));
        return field;
    }
}
