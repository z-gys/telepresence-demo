package ru.zgys.demo.config

import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.converter.MappingJackson2MessageConverter
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory


@Configuration
class RabbitmqConfig: RabbitListenerConfigurer {

    override fun configureRabbitListeners(registrar: RabbitListenerEndpointRegistrar) {
        registrar.messageHandlerMethodFactory = messageHandlerMethodFactory()
    }

    @Bean
    fun messageHandlerMethodFactory(): MessageHandlerMethodFactory {
        val messageHandlerMethodFactory = DefaultMessageHandlerMethodFactory()
        messageHandlerMethodFactory.setMessageConverter(consumerJackson2MessageConverter())
        return messageHandlerMethodFactory
    }

    @Bean
    fun consumerJackson2MessageConverter(): MappingJackson2MessageConverter {
        return MappingJackson2MessageConverter()
    }
}