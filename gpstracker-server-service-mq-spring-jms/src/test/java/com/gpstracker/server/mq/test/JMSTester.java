package com.gpstracker.server.mq.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.model.internal.mq.InternalMessage;
import com.gpstracker.server.model.internal.mq.InternalMessageType;
import com.gpstracker.server.service.mq.CommonMessageQueueService;

public class JMSTester {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/MessgageQueueContext.xml");

        CommonMessageQueueService mqService = (CommonMessageQueueService) context.getBean("messageQueueService");
        
        boolean doLoop = true;
        while (doLoop) {
            boolean readMessage = false;
            if (readMessage) {
                InternalMessage inMessage = mqService.pullMessage("test");
                GlobalPosition gps = (GlobalPosition) inMessage.getMessageContent();
            } else {
                GlobalPosition gps = new GlobalPosition();
                gps.setLatitude(111.00);
                gps.setLongitude(222.00);
                
                InternalMessage outMessage = new InternalMessage();
                outMessage.setMessageContent(gps);
                outMessage.setMessageType(InternalMessageType.INTERNAL_MESSAGE_PROCESSING);
                
                mqService.pushMesssage(outMessage, "test");        
            }
        }
        
        
        
        System.out.println("Breakpoint");
    }

}
