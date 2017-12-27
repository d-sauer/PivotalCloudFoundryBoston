package com.example.commons;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscoveryClientMetadata {

    private static final Logger logger = LoggerFactory.getLogger(DiscoveryClientMetadata.class);

    public DiscoveryClientMetadata() {
        logger.debug("Collect metadata for the Registry");
    }
}
