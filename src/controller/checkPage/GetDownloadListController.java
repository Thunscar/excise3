package controller.checkPage;

import dao.DownloadDao;
import vo.Download;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/getDownloadList.do")
public class GetDownloadListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        DownloadDao downloadDao = new DownloadDao();
        try {
            ArrayList<Download> downloadList = downloadDao.getDownloadList();
            request.setAttribute("DownloadList",downloadList);


        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("download.jsp");
        dispatcher.forward(request,response);
    }

}
