package com.psodex.rest.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;

public class JwtTokenFilter extends OncePerRequestFilter {

	private JwtTokenProvider tokenProvider;

	public JwtTokenFilter(JwtTokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = request.getHeader("Authorization");
		if (token != null) {
			try {
				Claims claims = tokenProvider.getClaimsFromToken(token);
				if (!claims.getExpiration().before(new Date())) {
					Authentication authentication = tokenProvider.getAuthentication(claims.getSubject());
					if (authentication.isAuthenticated()) {
						SecurityContextHolder.getContext().setAuthentication(authentication);
					}
				}
			} catch (RuntimeException e) {
				try {
					SecurityContextHolder.clearContext();
					response.setContentType("application/json");
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					response.getWriter().println(
							new JSONObject().put("exception", "expired or invalid JWT Token" + e.getMessage()));
				} catch (IOException | JSONException e1) {
					e1.printStackTrace();
				}
				return;
			}
		}
		filterChain.doFilter(request, response);
	}

}
