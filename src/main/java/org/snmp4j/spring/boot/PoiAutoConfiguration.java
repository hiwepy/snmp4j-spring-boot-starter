package org.snmp4j.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

/**
 * Auto-configuration for SNMP4J properties.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@AutoConfiguration
@EnableConfigurationProperties(PoiProperties.class)
public class PoiAutoConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(PoiAutoConfiguration.class);

	private final ApplicationContext applicationContext;

	private final PoiProperties properties;

	public PoiAutoConfiguration(ApplicationContext applicationContext, PoiProperties properties) {
		this.applicationContext = applicationContext;
		this.properties = properties;
		logger.info("PoiAutoConfiguration initialized with prefix '{}'", PoiProperties.PREFIX);
	}

    /**
     * <p>Returns the application context.</p>
     * @return the get application context
     */
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

    /**
     * <p>Returns the properties.</p>
     * @return the get properties
     */
	public PoiProperties getProperties() {
		return properties;
	}

}
