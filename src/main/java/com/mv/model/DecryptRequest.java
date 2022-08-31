package com.mv.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DecryptRequest {

	@NotNull
	private String encryptedValue;
}
