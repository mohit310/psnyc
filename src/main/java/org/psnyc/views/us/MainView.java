package org.psnyc.views.us;

import io.dropwizard.views.View;
import org.psnyc.core.authentication.User;
import org.psnyc.data.NavigationData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mk on 8/14/14.
 */
public class MainView extends View {

    private final NavigationData navigationData;
    private final String region;
    private final Map<String, Object> dataMap = new HashMap<String, Object>();

    public MainView(String region, String menu, String template, String key, Object data) {
        super("main.ftl");
        this.region = region;
        navigationData = new NavigationData(menu, template);
        dataMap.put(key, data);
    }

    public void addData(String key, Object data) {
        dataMap.put(key, data);
    }

    public NavigationData getNavigationData() {
        return navigationData;
    }

    public String getRegion() {
        return region;
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

}
