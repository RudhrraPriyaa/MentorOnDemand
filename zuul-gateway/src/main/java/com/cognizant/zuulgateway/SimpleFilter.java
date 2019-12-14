package com.cognizant.zuulgateway;

import com.netflix.zuul.ZuulFilter;

public class SimpleFilter extends ZuulFilter {

	@Override
	public Object run() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		// return false;
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		// return 0;
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		// return null;
		return "pre";
	}

}
