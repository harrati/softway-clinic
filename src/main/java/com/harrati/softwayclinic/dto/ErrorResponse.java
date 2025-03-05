package com.harrati.softwayclinic.dto;

import org.springframework.http.HttpStatus;

public record ErrorResponse(String errorClass, HttpStatus status, String message) { }