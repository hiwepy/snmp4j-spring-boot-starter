package org.snmp4j.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Properties;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link PoiProperties}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
class PoiPropertiesTest {

    @Test
    void defaultValues() {
        PoiProperties props = new PoiProperties();
        assertThat(props.getSettings()).isNotNull();
        assertThat(props.getSettings()).isEmpty();
        assertThat(props.getTemplateLoaderPath()).containsExactly(PoiProperties.DEFAULT_TEMPLATE_LOADER_PATH);
        assertThat(props.isPreferFileSystemAccess()).isTrue();
        assertThat(props.isAutoCheck()).isFalse();
    }

    @Test
    void constants() {
        assertThat(PoiProperties.DEFAULT_TEMPLATE_LOADER_PATH).isEqualTo("classpath:/templates/");
        assertThat(PoiProperties.DEFAULT_PREFIX).isEqualTo("");
        assertThat(PoiProperties.DEFAULT_SUFFIX).isEqualTo(".httl");
    }

    @Test
    void setSettings() {
        PoiProperties props = new PoiProperties();
        Properties settings = new Properties();
        settings.setProperty("key1", "value1");
        props.setSettings(settings);
        assertThat(props.getSettings()).containsEntry("key1", "value1");
    }

    @Test
    void setTemplateLoaderPath() {
        PoiProperties props = new PoiProperties();
        props.setTemplateLoaderPath("/custom/path");
        assertThat(props.getTemplateLoaderPath()).containsExactly("/custom/path");
    }

    @Test
    void setPreferFileSystemAccess() {
        PoiProperties props = new PoiProperties();
        props.setPreferFileSystemAccess(false);
        assertThat(props.isPreferFileSystemAccess()).isFalse();
    }

    @Test
    void setAutoCheck() {
        PoiProperties props = new PoiProperties();
        props.setAutoCheck(true);
        assertThat(props.isAutoCheck()).isTrue();
    }

}
