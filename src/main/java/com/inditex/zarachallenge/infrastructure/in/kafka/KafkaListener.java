package com.inditex.zarachallenge.infrastructure.in.kafka;

import java.util.function.Consumer;

import com.inditex.zarachallenge.application.ports.in.UpdateStockAvailabilityPort;
import com.inditex.zarachallenge.infrastructure.in.kafka.mappers.ProductAvailabilityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.inditex.zarachallenge.infrastructure.in.kafka.events.ProductAvailablityEvent;

@Component
public class KafkaListener {

	private final UpdateStockAvailabilityPort updateStockAvailabilityPort;
	private final ProductAvailabilityMapper mapper;
	public KafkaListener(UpdateStockAvailabilityPort updateStockAvailabilityPort,
						 ProductAvailabilityMapper mapper) {
		this.updateStockAvailabilityPort = updateStockAvailabilityPort;
		this.mapper=mapper;
	}

	@Bean
	public Consumer<Message<ProductAvailablityEvent>> KafkaConsumer() {

		return message -> {
			updateStockAvailabilityPort.updateAvailability(mapper.toProductAvailability(message.getPayload()));

		};
	}

}
