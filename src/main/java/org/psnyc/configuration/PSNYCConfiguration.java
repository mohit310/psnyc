package org.psnyc.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by mk on 8/13/14.
 */
public class PSNYCConfiguration extends Configuration{

    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory mysqlDatabase = new DataSourceFactory();

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return mysqlDatabase;
    }



}
