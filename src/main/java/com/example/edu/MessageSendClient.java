package com.example.edu;

import com.example.edu.model.MessagePayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "messageSendClient", url = "https://hook.dooray.com/services")
public interface MessageSendClient {

    @PostMapping("/{serviceId}/{botId}/{botToken}")
    String sendMessage(@RequestBody MessagePayload messagePayload,
                       @PathVariable Long serviceId, @PathVariable Long botId, @PathVariable String botToken);
}
