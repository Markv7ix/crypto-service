package com.mv.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EncryptRequest {

	@NotNull
	private String value;
}
