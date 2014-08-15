package org.psnyc.resource;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.views.View;
import org.apache.commons.lang.StringUtils;
import org.psnyc.data.TotalHits;
import org.psnyc.views.HomeView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mk on 8/13/14.
 */
@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HomeResource {

    public HomeResource(){
    }

    @GET
    public View displayHome(@PathParam("menu") String menuItem) {
        if(StringUtils.isEmpty(menuItem))
            return new HomeView();
        else
            return new HomeView();
    }

}
