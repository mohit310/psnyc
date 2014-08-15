package org.psnyc;

import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.views.ViewBundle;
import org.psnyc.configuration.PSNYCConfiguration;
import org.psnyc.resource.HomeResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by mk on 8/13/14.
 */
public class PSNYCApplication extends Application<PSNYCConfiguration> {

    @Override
    public void initialize(Bootstrap<PSNYCConfiguration> psnycConfigurationBootstrap) {

        //psnycConfigurationBootstrap.addBundle(new AssetsBundle("/assets/", "/"));
        psnycConfigurationBootstrap.addBundle(new AssetsBundle("/assets/css", "/css", null, "css"));
        psnycConfigurationBootstrap.addBundle(new AssetsBundle("/assets/js", "/js", null, "js"));
        psnycConfigurationBootstrap.addBundle(new AssetsBundle("/assets/font", "/font", null, "font"));
        psnycConfigurationBootstrap.addBundle(new AssetsBundle("/assets/images", "/images", null, "images"));

        psnycConfigurationBootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(PSNYCConfiguration psnycConfiguration, Environment environment) throws Exception {
        final HomeResource homeResource = new HomeResource();
        environment.jersey().register(homeResource);
    }

    public static void main(String[] args) throws Exception{
        new PSNYCApplication().run(args);
    }
}
