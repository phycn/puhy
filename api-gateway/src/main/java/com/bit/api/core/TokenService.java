package com.bit.api.core;

/**
 *
 */
public interface TokenService {

    public Token createToken();

    public Token getToken(String token);
}
