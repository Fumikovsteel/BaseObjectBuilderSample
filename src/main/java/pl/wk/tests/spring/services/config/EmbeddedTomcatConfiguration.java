package pl.wk.tests.spring.services.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Fumik on 5/27/2017.
 */
@Configuration
public class EmbeddedTomcatConfiguration {

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat
                = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint sc = new SecurityConstraint();
                sc.setUserConstraint("CONFIDENTIAL");
                SecurityCollection sColl = new SecurityCollection();
                sColl.addPattern("/*");
                sc.addCollection(sColl);
                context.addConstraint(sc);
            }
        };

        tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());

        return tomcat;
    }

    private Connector initiateHttpConnector() {
        Connector connector =
                new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        connector.setRedirectPort(8443);

        return connector;
    }
}
