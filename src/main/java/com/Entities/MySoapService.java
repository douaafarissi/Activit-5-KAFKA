package com.Entities;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
@SpringBootApplication
@Service
public class MySoapService {

    private final WebServiceTemplate webServiceTemplate;

    public MySoapService(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public String invokeSoapService(String requestPayload) {
        // Use webServiceTemplate to send SOAP request and receive the response
        // You may need to adjust this method based on your specific SOAP service
        Object response = webServiceTemplate.marshalSendAndReceive("http://example.com/soap-endpoint", requestPayload);
        // Process the response
        return response.toString();
    }
}


