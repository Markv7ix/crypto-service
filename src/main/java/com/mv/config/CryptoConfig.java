package com.mv.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="crypto-service.config.crypto")
public class CryptoConfig {

	private String encryptionKey;
	
	private String iv;
	
	private String algorithm;
}
