package com.soft1851.gongcheng.config;


import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wl
 * @ClassNamesad
 * @Description TODO
 * @Date 2020/5/17
 * @Version 1.0
 */
@Configuration
public class TrustedPortConfiguration {

    // 提供给外部接口使用的端口

    @Value("${server.port:8080}")
    private String serverPort;

    @Value("${management.port:${server.port:8080}}")
    private String managementPort;

    // 提供给内部接口使用的端口

    @Value("${server.trustedPort:9003}")
    private String trustedPort;

    @Bean
    public WebServerFactoryCustomizer servletContainer() {
        Connector[] additionalConnectors = this.additionalConnector();

        ServerProperties serverProperties = new ServerProperties();
        return new TomcatMultiConnectorServletWebServerFactoryCustomizer(serverProperties, additionalConnectors);
    }

    private Connector[] additionalConnector() {
        if (StringUtils.isEmpty(this.trustedPort) || "null".equals(trustedPort)) {
            return null;
        }

        Set<String> defaultPorts = new HashSet<>();
        defaultPorts.add(serverPort);
        defaultPorts.add(managementPort);

        if (!defaultPorts.contains(trustedPort)) {
            Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
            connector.setScheme("http");
            connector.setPort(Integer.valueOf(trustedPort));
            return new Connector[]{connector};
        } else {
            return new Connector[]{};
        }
    }

    private class TomcatMultiConnectorServletWebServerFactoryCustomizer extends TomcatServletWebServerFactoryCustomizer {
        private final Connector[] additionalConnectors;

        TomcatMultiConnectorServletWebServerFactoryCustomizer(ServerProperties serverProperties, Connector[] additionalConnectors) {
            super(serverProperties);
            this.additionalConnectors = additionalConnectors;
        }

        @Override
        public void customize(TomcatServletWebServerFactory factory) {
            super.customize(factory);

            if (additionalConnectors != null && additionalConnectors.length > 0) {
                factory.addAdditionalTomcatConnectors(additionalConnectors);
            }
        }
    }
}