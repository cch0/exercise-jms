package org.cch.exercise.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class Application {

    // Default jmsListenerContainerFactory is created by JmsAnnotationDrivenConfiguration when custom one is not
    // defined. JmsAnnotationDrivenConfiguration is pulled in by JmsAutoConfiguration.

    // JmsAutoConfiguration is specified in spring.factory file from spring-boot-autoconfigurer.jar

    // Default jmsTemplate is created by JmsAutoConfiguration when custom one is not defined (ConditionalOnMissingBean).

    // ActiveMQAutoConfiguration is specified in spring.factory file from spring-boot-autoconfigurer.jar

    // ActiveMQConnectionFactoryConfiguration is pulled in by ActiveMQAutoConfiguration.

    // Default JMS ConnectionFactory is created by ActiveMQConnectionFactoryConfiguration when custom
    // ConnectionFactory bean is not defined (ConditionalOnMissingBean)


    public static void main(String[] args) {

        // Clean out any ActiveMQ data from a previous run
//        FileSystemUtils.deleteRecursively(new File("activemq-data"));

        ApplicationContext context = SpringApplication.run(Application.class, args);

    }
}
