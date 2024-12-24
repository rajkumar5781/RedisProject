package com.redis;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import redis.clients.jedis.UnifiedJedis;
import java.util.logging.Logger;
import java.util.logging.Level;

import java.io.IOException;
import java.util.HashSet;

import org.json.JSONObject;

/**
 * Servlet implementation class RedisDetailsForParticularKey
 */
@WebServlet("/RedisDetailsForParticularKey")
public class RedisDetailsForParticularKey extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(RedisDetailsForParticularKey.class.getName());
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedisDetailsForParticularKey() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UnifiedJedis jedis = new RedisConnection().getInstance();
		String str = request.getParameter("key");
		JSONObject object = new JSONObject();
		try {
		if(str!=null && !str.isEmpty()) {
			object.put("data", jedis.get(str));
		}
		}
		catch(Exception e) {
			LOGGER.log(Level.WARNING , e.toString());
		}
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
