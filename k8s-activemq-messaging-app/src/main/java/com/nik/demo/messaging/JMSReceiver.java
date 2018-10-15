package com.nik.demo.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Class to have message listerner api that uses {@link JmsListener} capability of spring-jms.
 * @author nikhil.bhide
 *
 */

@Service
public class JMSReceiver {

  @JmsListener(destination = "${spring.activemq.receiver.queue}")
  public void receive(String message) {
    System.out.format("received message=%s", message);
  }
}