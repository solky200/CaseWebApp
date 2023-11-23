package controller;


import dao.PhoneDao;
import model.Phone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/phones")
public class PhoneServlet extends HttpServlet {
    private PhoneDao phoneDAO;

    @Override
    public void init() throws ServletException {
        phoneDAO = new PhoneDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertPhone(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    updatePhone(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void updatePhone(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String color = req.getParameter("color");
        double price = Double.parseDouble(req.getParameter("price"));
        String urlImage = req.getParameter("urlImage");

        phoneDAO.updatePhone(new Phone(id, name, brand, color, price, urlImage));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("edit.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(req, resp);
                break;

            case "delete":
                try {
                    deletePhone(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;



            case "edit":
                try {
                    showEditForm(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;


            default:
                try {
                    listPhone(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Phone existingPhone = phoneDAO.selectPhone(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("edit.jsp");
        req.setAttribute("phone", existingPhone);
        requestDispatcher.forward(req, resp);
    }



    private void deletePhone(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        phoneDAO.deletePhone(id);
        List<Phone> phoneList = phoneDAO.selectALlPhone();
        req.setAttribute("phoneList", phoneList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(req, resp);
    }


    private void insertPhone(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String color = req.getParameter("color");
        double price = Double.parseDouble(req.getParameter("price"));
        String urlImage = req.getParameter("urlImage");
        phoneDAO.insertPhone(new Phone(name, brand, color, price, urlImage));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(req, resp);

    }


    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void listPhone(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Phone> phoneList = phoneDAO.selectALlPhone();
        req.setAttribute("phoneList", phoneList);
//        System.out.println(phoneList.size());
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req, resp);
    }

}
