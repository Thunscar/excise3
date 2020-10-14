package controller;

import vo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/exitLogin.do")
public class exitLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("User")!=null){
            User user = (User) session.getAttribute("User");
            System.out.println(new Date().toString() + " " + user + "退出登录");
            session.removeAttribute("User");

            Cookie[] cookies = request.getCookies();
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("userName")||
                        cookie.getName().equals("password")){

                    System.out.println(cookie.getName() + " Cookie已删除");

                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }


        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        dispatcher.forward(request,response);
    }

}
