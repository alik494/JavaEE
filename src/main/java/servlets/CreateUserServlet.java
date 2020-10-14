package servlets;

import dao.impl.UserDAOImpl;
import db.entity.Role;
import db.entity.User;
import org.apache.log4j.Logger;
import utils.InputDataCheck;
import utils.RegexContainer;
import utils.factories.DAOFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;


@WebServlet("/registration")

public class CreateUserServlet extends HttpServlet {
    /**
     * Instance of Logger
     */
    private static final Logger log = Logger.getLogger(CreateUserServlet.class);

    /**
     * Instance of PatientDataManipulations
     */
    /**
     * Instance of DAO factory
     */
    DAOFactory factory;

    public CreateUserServlet() {
        this.factory = new DAOFactory();

    }

    /**
     * Method performing HHTP GET request
     *
     * @param req  HttpRequest
     * @param resp HttpResponse
     * @throws ServletException On servlet error
     * @throws IOException      On error fulfilling the request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        log.info("Entering a registration page");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    /**
     * Method performing HHTP POST request
     *
     * @param req  HttpRequest
     * @param resp HttpResponse
     * @throws ServletException On servlet error
     * @throws IOException      On error fulfilling the request
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try {
            req.setCharacterEncoding("UTF-8");
            final String email = req.getParameter("email");
            final String name = req.getParameter("name");
            final String password = req.getParameter("password");
            final String password2 = req.getParameter("password2");
            boolean isValid = inputValidator(email, name, password);
            if (!isValid) {
                req.setAttribute("errorString", "You entered non-valid credentials. Please,try again.");
                req.getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
            }
            if (!password.equals(password2)) {
                req.setAttribute("errorString", "password are not equal");
                req.getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
            } else {
                UserDAOImpl userDAO = factory.createUserDao();
                if (userDAO.findByEmail(email) == null) {
                    Long userID = userDAO.getNextUserID();
                    User user = new User(userID, email, name, password, true, Collections.singleton(Role.USER));
                    userDAO.insert(user);
                    log.debug("New user after insert: " + user.toString());
                    //todo check manipulations and save data
                    resp.sendRedirect(req.getContextPath() + "/");
                } else {
                    log.debug("User with such credentials already exists.");
                    req.setAttribute("errorString", "User with such credentials already exists!");
                    req.getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);

                }
            }
        } catch (Exception ex) {
            log.error("An error occured while creating a new user ", ex);
            req.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

    /**
     * Method for validating input values using regular expressions
     *
     * @param name     name of the user to check
     * @param password password of the user to check
     * @return true if data is valid,else - false
     */
    public static boolean inputValidator(String email, String name, String password) {
        boolean isValid;
        isValid = InputDataCheck.inputCheck(email, RegexContainer.REGEX_EMAIL);
        if (!isValid) {
            log.debug("Non-valid email entered");
            return false;
        }
        isValid = InputDataCheck.inputCheck(name, RegexContainer.REGEX_NAME_ENG);
        if (!isValid) {
            log.debug("Non-valid name entered");
            return false;
        }
        isValid = InputDataCheck.inputCheck(password, RegexContainer.REGEX_PASSWORD);
        if (!isValid) {
            log.debug("Non-valid password entered");
            return false;
        }
        return true;
    }
}
