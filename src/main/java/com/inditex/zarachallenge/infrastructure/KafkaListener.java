package com.inditex.zarachallenge.infrastructure;

import java.util.function.Consumer;

import com.inditex.zarachallenge.application.UpdateStockAvailabilityService;
import com.inditex.zarachallenge.infrastructure.mappers.ProductMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.inditex.zarachallenge.infrastructure.model.ProductAvailablityEvent;

@Component
public class KafkaListener {

	private final UpdateStockAvailabilityService updateStockAvailabilityService;
	private final ProductMapper mapper;
	public KafkaListener(UpdateStockAvailabilityService updateStockAvailabilityService,
						 ProductMapper mapper) {
		this.updateStockAvailabilityService = updateStockAvailabilityService;
		this.mapper=mapper;
	}

	@Bean
	public Consumer<Message<ProductAvailablityEvent>> KafkaConsumer() {

		return message -> {
			updateStockAvailabilityService.updateAvailability(mapper.toDomain(message.getPayload()));

		};
	}

}
