package control;

import domain.Car;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ServiceJDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/")
public class CarControl extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceJDBC sj = new ServiceJDBC();
        Map<String, String[]> params = req.getParameterMap();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE HTML><html lang='ru'><head><title>Document</title></head><body>");

        if (params.isEmpty()) {
            writer.println("<h1>Доступные машины</h1><ul style='list-style-type:none'>");
            List<Car> cars = sj.getAll();
                for (Car car : cars) {
                writer.println("<p><a href='.?id=" + car.getId() + "'>" + car.getBrand() + "</a></p>");
            }
            writer.println("</ul>");
        } else {
            Car car = sj.getById(Long.parseLong(params.get("id")[0]));
            writer.println("<h1>" + car.getBrand() + "</h1>");
            writer.println("<p><a href='./'>Вернуться</a></p>");
            writer.println("<ul style='list-style-type:none'>");
writer.println("<li>ID: "+car.getId()+"</li>");
writer.println("<li>Цена: "+car.getPrice()+"</li>");
writer.println("<li>Год: "+car.getYear()+"</li>");
            writer.println("</ul>");
            writer.println("<p><a onclick='' tabindex='0' id='del'>Удалить</a></p>");

        }

        writer.println("</body></html>");
        writer.close();
    }




}