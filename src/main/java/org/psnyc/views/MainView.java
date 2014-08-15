package org.psnyc.views;

import io.dropwizard.views.View;
import org.psnyc.data.NavigationData;

/**
 * Created by mk on 8/14/14.
 */
public class MainView extends View{

    private final NavigationData navigationData;

    public MainView(String menu, String bodyTemplate) {
        super("main.ftl");
        this.navigationData= new NavigationData(menu, bodyTemplate);
    }

    public NavigationData getNavigationData() {
        return navigationData;
    }
}
