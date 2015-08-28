package org.cch.exercise.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Sender {

    @Autowired
    JmsTemplate jmsTemplate;

    @Scheduled(fixedRate=1000)
    public void heartBeat()
    {
        HeartBeat heartBeat = new HeartBeat(LocalDateTime.now());
        System.out.println("Sending heart beat: " + heartBeat);

        jmsTemplate.convertAndSend("heart-beat", heartBeat);
    }

    // use default containerFactory
    @JmsListener(destination = "acked")
    public void processAck(Message<Ack> message)
    {
        System.out.println("received ack: " + message.getPayload());
    }
}
