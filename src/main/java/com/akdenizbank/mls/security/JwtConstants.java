package com.akdenizbank.mls.security;

public class JwtConstants {

    public static final Long ACCESS_TOKEN_EXPIRATION_TIME = 1000L * 60 * 24 * 60 * 10;

    public static final String SECRET_KEY = "77397A24432646294A404E635266556A586E327234753778214125442A472D4B";

    public static final long REFRESH_TOKEN_EXPIRATION_TIME = 1000L * 60 * 24 * 60 * 30;
}
