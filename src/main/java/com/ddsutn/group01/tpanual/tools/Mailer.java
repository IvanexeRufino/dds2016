package com.ddsutn.group01.tpanual.tools;

import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.*;
import javax.ws.rs.core.MediaType;

public class Mailer {
    public static void send(String to, String subject, String content) throws Exception {
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("api", "key-93190349445fb7d8db3ad8e623b791de"));
        WebResource webResource =
            client.resource("https://api.mailgun.net/v3/mg.leandrobarragan.com/messages");

        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("from", "POI Manager <mailgun@mg.leandrobarragan.com>");
        formData.add("to", to);
        formData.add("subject", subject);
        formData.add("text", content);

        ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
            post(ClientResponse.class, formData);

        if (response.getStatus() < 200 || response.getStatus() >= 300) {
            // Un codigo http de tipo 2XX indica que pudo enviar
            throw new Exception("Problemas al enviar el mail");
        }
    }
}
