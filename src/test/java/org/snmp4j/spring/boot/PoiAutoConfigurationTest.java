package org.snmp4j.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Tests for {@link PoiAutoConfiguration}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
class PoiAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(PoiAutoConfiguration.class));

    @Test
    void propertiesAreBound() {
        this.contextRunner
                .withPropertyValues("poi.auto-check=true", "poi.prefer-file-system-access=false")
                .run(context -> {
                    assertThat(context).hasSingleBean(PoiProperties.class);
                    PoiProperties props = context.getBean(PoiProperties.class);
                    assertThat(props.isAutoCheck()).isTrue();
                    assertThat(props.isPreferFileSystemAccess()).isFalse();
                });
    }

    @Test
    void defaultPropertiesLoaded() {
        this.contextRunner.run(context -> {
            assertThat(context).hasSingleBean(PoiProperties.class);
            PoiProperties props = context.getBean(PoiProperties.class);
            assertThat(props.isAutoCheck()).isFalse();
            assertThat(props.isPreferFileSystemAccess()).isTrue();
        });
    }

    @Test
    void autoConfigurationBeanHasGetters() {
        this.contextRunner.run(context -> {
            assertThat(context).hasSingleBean(PoiAutoConfiguration.class);
            PoiAutoConfiguration config = context.getBean(PoiAutoConfiguration.class);
            assertThat(config.getProperties()).isNotNull();
            assertThat(config.getApplicationContext()).isNotNull();
        });
    }

}
