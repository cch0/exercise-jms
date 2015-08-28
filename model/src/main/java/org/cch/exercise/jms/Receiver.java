package org.cch.exercise.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "heart-beat")
    @SendTo("acked")
    public Ack processHeartBeat(Message<HeartBeat> message)
    {
        System.out.println("received heart beat: " + message.getPayload());

        return new Ack(message.getPayload().time);
    }
}
