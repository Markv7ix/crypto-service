package com.mv.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

/**
 * Configuration class.
 * 
 * @author 2220832
 *
 */
@Getter
@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "crypto-service.config.crypto")
public class CryptoConfig {

  /**
   * Encryption key.
   */
  private String encryptionKey;

  /**
   * Initailization vector.
   */
  private String iv;

  /**
   * Algorithm.
   */
  private String algorithm;
}
