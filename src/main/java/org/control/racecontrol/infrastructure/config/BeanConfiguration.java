package org.control.racecontrol.infrastructure.config;

import org.control.racecontrol.application.service.RaceApplicationService;
import org.control.racecontrol.domain.port.input.RegisterResultUseCase;
import org.control.racecontrol.domain.port.output.RaceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public RegisterResultUseCase registerResultUseCase(RaceRepository raceRepository) {
        return new RaceApplicationService(raceRepository);
    }
}
