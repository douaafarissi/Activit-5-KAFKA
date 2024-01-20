package com.Entities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
@Configuration
public class SoapClientConfig {


    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate template = new WebServiceTemplate();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.your.package"); // Specify the package containing your generated JAXB classes
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
        // Other configurations, such as setting default uri, interceptors, etc.
        return template;
    }
}
