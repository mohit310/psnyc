package org.psnyc.views;

import io.dropwizard.views.View;
import org.psnyc.data.NavigationData;

/**
 * Created by mohit on 8/20/14.
 */
public class GlobalView extends View {
    private final NavigationData navigationData;


    public GlobalView(String template) {
        super(template);
        this.navigationData = new NavigationData("GlobalHome", template);
    }

    public NavigationData getNavigationData() {
        return navigationData;
    }
}
