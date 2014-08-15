package org.psnyc.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by mk on 8/14/14.
 */
public class NavigationData {

    private String menu;
    private String template;

    public NavigationData(String menu, String template) {
        this.menu = menu;
        this.template = template;
    }

    @JsonProperty
    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
