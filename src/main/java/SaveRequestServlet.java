import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SaveRequestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("name").length() != 0) {
            req.setAttribute("isNameCorrect", true);
            req.setAttribute("name", req.getParameter("name"));
            req.setAttribute("nameLine", req.getParameter("name"));
        } else {
            req.setAttribute("isNameCorrect", false);
            req.setAttribute("nameLine", "Name");
        }
        if (req.getParameter("surname").length() != 0) {
            req.setAttribute("isSurnameCorrect", true);
            req.setAttribute("surname", req.getParameter("surname"));
            req.setAttribute("surnameLine", req.getParameter("surname"));
        } else {
            req.setAttribute("isSurnameCorrect", false);
            req.setAttribute("surnameLine", "Surname");
        }
        if (req.getParameter("age").length() != 0) {
            req.setAttribute("isAgeCorrect", true);
            req.setAttribute("age", req.getParameter("age"));
            req.setAttribute("ageLine", req.getParameter("age"));
        } else {
            req.setAttribute("isAgeCorrect", false);
            req.setAttribute("ageLine", "Age");
        }
        if (req.getParameter("email").length() != 0) {
            req.setAttribute("isEmailCorrect", true);
            req.setAttribute("email", req.getParameter("email"));
            req.setAttribute("emailLine", req.getParameter("email"));
        } else {
            req.setAttribute("isEmailCorrect", false);
            req.setAttribute("emailLine", "Email");
        }
        if (req.getParameter("name").length() != 0 && req.getParameter("surname").length() != 0
                && Integer.parseInt(req.getParameter("age")) > 0 && req.getParameter("email").length() != 0) {
            req.setAttribute("name", req.getParameter("name"));
            req.setAttribute("surname", req.getParameter("surname"));
            req.setAttribute("age", req.getParameter("age"));
            req.setAttribute("email", req.getParameter("email"));
            getServletContext().getRequestDispatcher("/save_success.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/save-request.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isNameCorrect", true);
        req.setAttribute("isSurnameCorrect", true);
        req.setAttribute("isAgeCorrect", true);
        req.setAttribute("isEmailCorrect", true);
        req.setAttribute("nameLine", "Name");
        req.setAttribute("surnameLine", "Surname");
        req.setAttribute("ageLine", "Age");
        req.setAttribute("emailLine", "Email");
        getServletContext().getRequestDispatcher("/save-request.jsp").forward(req, resp);
    }
}
