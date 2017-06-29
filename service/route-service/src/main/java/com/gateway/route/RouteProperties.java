package com.gateway.route;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "route-service")
public class RouteProperties {

    Map<String, String> redirect = new HashMap<>();

    public Map<String, String> getRedirect() {
        return redirect;
    }

    public void setRedirect(Map<String, String> redirect) {
        this.redirect = redirect;
    }


}
