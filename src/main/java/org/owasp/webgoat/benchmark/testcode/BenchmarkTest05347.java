package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05347")
public class BenchmarkTest05347 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a18277 = param; //assign
		StringBuilder b18277 = new StringBuilder(a18277);  // stick in stringbuilder
		b18277.append(" SafeStuff"); // append some safe content
		b18277.replace(b18277.length()-"Chars".length(),b18277.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map18277 = new java.util.HashMap<String,Object>();
		map18277.put("key18277", b18277.toString()); // put in a collection
		String c18277 = (String)map18277.get("key18277"); // get it back out
		String d18277 = c18277.substring(0,c18277.length()-1); // extract most of it
		String e18277 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d18277.getBytes() ) )); // B64 encode and decode it
		String f18277 = e18277.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g18277 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g18277); // reflection
		
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, new int[] {1,2} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}