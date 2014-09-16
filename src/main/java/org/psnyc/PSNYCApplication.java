package org.psnyc;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.psnyc.configuration.PSNYCConfiguration;
import org.psnyc.core.authentication.LoginUserCheckProvider;
import org.psnyc.core.dao.UserDAO;
import org.psnyc.core.filter.RegionCookieFilter;
import org.psnyc.core.resource.EmailCheckResource;
import org.psnyc.core.resource.GlobalHomeResource;
import org.psnyc.core.resource.LoginResource;
import org.psnyc.core.resource.SignUpResource;
import org.psnyc.core.resource.us.AboutUsResource;
import org.psnyc.core.resource.us.ContactUsResource;
import org.psnyc.core.resource.us.FieldsResource;
import org.psnyc.core.resource.us.HomeResource;
import org.skife.jdbi.v2.DBI;

/**
 * Created by mk on 8/13/14.
 */
public class PSNYCApplication extends Application<PSNYCConfiguration> {

    public static void main(String[] args) throws Exception {
        new PSNYCApplication().run(args);
    }

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

        //DAO
        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);

        environment.jersey().getResourceConfig().getProviderClasses().add(LoginUserCheckProvider.class);

        environment.jersey().getResourceConfig().getContainerResponseFilters().add(new RegionCookieFilter());
        environment.jersey().register(new LoginResource(userDAO));
        environment.jersey().register(new GlobalHomeResource());
        environment.jersey().register(new HomeResource());
        environment.jersey().register(new FieldsResource());
        environment.jersey().register(new AboutUsResource());
        environment.jersey().register(new ContactUsResource());
        environment.jersey().register(new SignUpResource(jdbi, userDAO));
        environment.jersey().register(new EmailCheckResource(userDAO));


    }

}
