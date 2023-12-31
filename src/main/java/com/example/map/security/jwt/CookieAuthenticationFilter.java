package com.example.map.security.jwt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.server.Cookie;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.naming.AuthenticationException;
import java.io.IOException;
//
//public class CookieAuthenticationFilter  extends AbstractAuthenticationProcessingFilter {
//    public CookieAuthenticationFilter( RequestMatcher requestMatcher ) {
//        super( requestMatcher );
//        setAuthenticationManager( super.getAuthenticationManager() );
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response )
//            throws AuthenticationException, IOException, ServletException {
//
//        String token = "";
//
//        // get token from a Cookie
//        Cookie[] cookies = request.getCookies();
//
//        if( cookies == null || cookies.length < 1 ) {
//            throw new AuthenticationServiceException( "Invalid Token" );
//        }
//
//        Cookie sessionCookie = null;
//        for( Cookie cookie : cookies ) {
//            if( ( "someSessionId" ).equals( cookie.getName() ) ) {
//                sessionCookie = cookie;
//                break;
//            }
//        }
//
//        // TODO: move the cookie validation into a private method
//        if( sessionCookie == null || StringUtils.isEmpty( sessionCookie.getValue() ) ) {
//            throw new AuthenticationServiceException( "Invalid Token" );
//        }
//
//        JWTAuthenticationToken jwtAuthentication = new JWTAuthenticationToken( sessionCookie.getValue(), null, null );
//
//        return jwtAuthentication;
//
//    }
//
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res,
//                         FilterChain chain) throws IOException, ServletException {
//        super.doFilter(req, res, chain);
////    }
//}
