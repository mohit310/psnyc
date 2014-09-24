package org.psnyc.core.dao;

import org.psnyc.core.authentication.User;
import org.psnyc.core.dao.mapper.FieldMapper;
import org.psnyc.core.dao.mapper.UserMapper;
import org.psnyc.data.Field;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * Created by mk on 9/20/14.
 */
public interface FieldDAO {

    @Mapper(FieldMapper.class)
    @SqlQuery("select * from Field where city=:city")
    List<Field> getFieldByCity(@Bind("city") String city);

    @Mapper(FieldMapper.class)
    @SqlQuery("select * from Field where country=:country")
    List<Field> getFieldByCountry(@Bind("country") String country);

    @Mapper(FieldMapper.class)
    @SqlQuery("select * from Field where name=:name")
    Field getFieldByName(@Bind("name") String name);

}

