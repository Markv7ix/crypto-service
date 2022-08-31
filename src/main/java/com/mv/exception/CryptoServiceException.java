package com.mv.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Crypto service exception.
 * 
 * @author 2220832
 *
 */
@Getter
@Setter
public class CryptoServiceException extends RuntimeException {

  /**
   * Serial version
   */
  private static final long serialVersionUID = 1L;

  /**
   * Error code.
   */
  private String code;

  /**
   * Error message.
   */
  private String message;

  /**
   * Error details.
   */
  private String details;

  /**
   * Error timestamp.
   */
  private long timestamp;

  /**
   * Default constructor.
   * 
   * @param code
   * @param message
   */
  public CryptoServiceException(String code, String message) {
    this.code = code;
    this.message = message;
    this.timestamp = System.currentTimeMillis();
  }
}
