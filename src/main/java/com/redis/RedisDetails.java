package com.redis;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import redis.clients.jedis.UnifiedJedis;

import java.io.IOException;
import java.util.HashSet;

import org.json.JSONObject;

/**
 * Servlet implementation class RedisDetails
 */
@WebServlet("/RedisDetails")
public class RedisDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedisDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UnifiedJedis jedis = new RedisConnection().getInstance();
		HashSet<String> list = new HashSet<>();
		if(jedis!=null) {
			list =  (HashSet<String>) jedis.keys("*");
		}
		JSONObject object = new JSONObject();
		object.put("data", list);
		response.setContentType("application/json");
        response.getWriter().print(object);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
