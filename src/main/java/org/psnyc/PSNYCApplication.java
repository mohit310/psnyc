package org.psnyc;

import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.views.ViewBundle;
import org.psnyc.configuration.PSNYCConfiguration;
import org.psnyc.core.filter.RegionCookieFilter;
import org.psnyc.core.resource.GlobalHomeResource;
import org.psnyc.core.resource.us.AboutUsResource;
import org.psnyc.core.resource.us.ContactUsResource;
import org.psnyc.core.resource.us.FieldsResource;
import org.psnyc.core.resource.us.HomeResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

/**
 * Created by mk on 8/13/14.
 */
public class PSNYCApplication extends Application<PSNYCConfiguration> {

    @Override
    public void initialize(Bootstrap<PSNYCConfiguration> psnycConfigurationBootstrap) {

        psnycConfigurationBootstrap.addBundle(new AssetsBundle("/assets/css", "/css", null, "css"));
        psnycConfigurationBootstrap.addBundle(new AssetsBundle("/assets/js", "/js", null, "js"));
        psnycConfigurationBootstrap.addBundle(new AssetsBundle("/assets/fonts", "/fonts", null, "fonts"));
        psnycConfigurationBootstrap.addBundle(new AssetsBundle("/assets/images", "/images", null, "images"));

        psnycConfigurationBootstrap.addBundle(new ViewBundle());

        psnycConfigurationBootstrap.addBundle(new MigrationsBundle<PSNYCConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(PSNYCConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(PSNYCConfiguration psnycConfiguration, Environment environment) throws Exception {


        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, psnycConfiguration.getDataSourceFactory(), "mysql");


        environment.servlets().addFilter("RegionCookieFilter", new RegionCookieFilter())
                .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

        environment.jersey().register(new GlobalHomeResource());
        environment.jersey().register(new HomeResource());
        environment.jersey().register(new FieldsResource());
        environment.jersey().register(new AboutUsResource());
        environment.jersey().register(new ContactUsResource());



    }

    public static void main(String[] args) throws Exception{
        new PSNYCApplication().run(args);
    }
}
