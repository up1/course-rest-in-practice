package api.servlet;


import api.bean.Message;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Message helloMessage = new Message();
        helloMessage.setId(1);
        helloMessage.setName("First time");
        helloMessage.setDescription("Nice to meet you all");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), helloMessage);

    }
}
