package myPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String[] joke = {"Why do Java developers wear glasses? Because they don't C#!",
   	        "I told my computer I needed a break, and now it won't stop sending me Kit Kat bars.",
   	        "Why don't programmers like nature? It has too many bugs.",
   	        "How many programmers does it take to change a light bulb? None, it's a hardware problem."};
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//add history using cookies
		//add api to display more jokes
		String str1 = request.getParameter("num1");
		String str2 = request.getParameter("num2");
		String str3 = request.getParameter("selector");
		
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		int res;
		
		int randomIndex = (int)(Math.random() * joke.length);
		String randomJoke = joke[randomIndex];
		
		if(str3.equals("1")) {
			res=num1+num2;
		}
		else if(str3.equals("2")) {
			res=num1-num2;
		}
		else if(str3.equals("3")) {
			res=num1*num2;
		}
		else {
			res=num1/num2;
		}

        // Retrieve the current history from the cookies
        String currentHistory = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("additionHistory")) {
                    currentHistory = cookie.getValue();
                }
            }
        }

        // Simulate a new addition (e.g., user added 5)
        String newAddition = Integer.toString(res);

        // Update the history
        if (!currentHistory.isEmpty()) {
            currentHistory += "|";
        }
        currentHistory += newAddition;

        // Create or update the cookie with the new history
        Cookie historyCookie = new Cookie("additionHistory", currentHistory);
        historyCookie.setMaxAge(24 * 60 * 60); // 1 day
        response.addCookie(historyCookie);
		response.sendRedirect("MyJSP.jsp?ans="+res+"&joke="+randomJoke);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

	}

}
