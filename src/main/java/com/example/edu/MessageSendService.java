package com.example.edu;

import com.example.edu.controller.Auth;
import com.example.edu.model.MessagePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class MessageSendService {

//    @Autowired
    private MessageSendClient messageSendClient;

    @Autowired
    private RestTemplate restTemplate;

    public void send(String text, String name){
//        /3204376758577275363/3812545325115818285/4r4jIFg8Re6jRcY7YIihsw
//        messageSendClient.sendMessage(new MessagePayload(name, "", text, Arrays.asList()), 3204376758577275363L , 3812545325115818285L ,"4r4jIFg8Re6jRcY7YIihsw");
        MessagePayload messagePayload = new MessagePayload(name, "", text, Arrays.asList());
        String doorayUrl = "https://hook.dooray.com/services/";
        StringBuilder stringBuilder = new StringBuilder(doorayUrl);
        stringBuilder.append("3204376758577275363/");
        stringBuilder.append("3812545325115818285/");
        stringBuilder.append("4r4jIFg8Re6jRcY7YIihsw");
        String requestUrl = stringBuilder.toString();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpEntity<MessagePayload> messagePayloadHttpEntity = new HttpEntity<>(messagePayload, httpHeaders);

        restTemplate.exchange(requestUrl, HttpMethod.POST, messagePayloadHttpEntity , String.class);
    }

}
