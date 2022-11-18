package com.gabrielle.prontoar.security;

import java.security.Key;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.gabrielle.prontoar.entity.Doctor;

// Methods to generate and validate token
public class TokenUtil {

    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";
    private static final String SECRET_KEY = "MyK3tt0osjSLo0@dk!SM2L@4fRc52DlP";
    private static final String EMISSOR = "Gabrielle";

    public static String createToken(Doctor doctor) {
        Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        String token = Jwts.builder()
                .setSubject(doctor.getName())
                .setIssuer(EMISSOR)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();

        return PREFIX + token;
    }

    private static boolean isEmissorValid(String emissor) {
        return emissor.equals(EMISSOR);
    }

    private static boolean isSubjectValid(String doctorName) {
        return doctorName != null && doctorName.length() > 0;
    }

    public static Authentication validate(HttpServletRequest request) {
        String token = request.getHeader(HEADER);
        token = token.replace(PREFIX, "");

        Jws<Claims> jwsClaims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(token);

        String doctorName = jwsClaims.getBody().getSubject();
        String issuer = jwsClaims.getBody().getIssuer();

        if (isSubjectValid(doctorName) && isEmissorValid(issuer)) {
            return new UsernamePasswordAuthenticationToken(doctorName, null, Collections.emptyList());
        }

        return null;
    }
}
