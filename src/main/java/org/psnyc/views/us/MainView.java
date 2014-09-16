package org.psnyc.views.us;

import io.dropwizard.views.View;
import org.psnyc.core.authentication.User;
import org.psnyc.data.NavigationData;

/**
 * Created by mk on 8/14/14.
 */
public class MainView extends View {

    private final NavigationData navigationData;
    private final String region;

    public MainView(String region, String menu, String template) {
        super("main.ftl");
        this.region = region;
        this.navigationData = new NavigationData(menu, template);
    }

    public NavigationData getNavigationData() {
        return navigationData;
    }

    public String getRegion() {
        return region;
    }

}
