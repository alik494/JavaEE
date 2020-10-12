package servlets;


import dao.impl.UserDAOImpl;
import db.entity.Role;
import db.entity.User;
import org.apache.log4j.Logger;
import utils.InputDataCheck;
import utils.PasswordEncryptorSHA256;
import utils.RegexContainer;
import utils.factories.DAOFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;


@WebServlet("/registration")

public class CreateUserServlet extends HttpServlet {
    /**
     * Instance of Logger
     */
//    private static final Logger log = Logger.getLogger(CreateUserServlet.class);
    /**
     * Instance of User
     */
    User user = null;
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
//        log.info("Entering a registration page");
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
        try {
            req.setCharacterEncoding("UTF-8");
            final String name = req.getParameter("name");
            final String password = req.getParameter("password");
            boolean isValid = inputValidator(name, password);
            if (!isValid) {
                req.setAttribute("message", "You entered non-valid credentials. Please,try again.");
                req.getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
            } else {
                UserDAOImpl userDAO = factory.createUserDao();

                if (userDAO.findByNameAndPass(name, PasswordEncryptorSHA256.encryptPasswordWithSHA256(password)) == null) {
                    User user;
                    if (name.equals("admin")) {
                        user = new User(name,  password, true,Collections.singleton(Role.ADMIN));
                    }else {
                        user = new User(name,  password, true,Collections.singleton(Role.USER));
                    }
//                    log.debug("New user: " + user.getUsername() + Arrays.asList(user.getRoles()));
                    userDAO.insert(user);
                   //todo check manipulations
                    resp.sendRedirect(req.getContextPath() + "/");
                } else {
//                    log.debug("User with such credentials already exists.");
                    req.setAttribute("message", "User with such credentials already exists!");
                     req.getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);

                }
            }
        } catch (Exception ex) {
//            log.error("An error occured while creating a new user", ex);
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
    public static boolean inputValidator(String name, String password) {
        boolean isValid;
        isValid = InputDataCheck.inputCheck(name, RegexContainer.REGEX_NAME_ENG);
        if (!isValid) {
//            log.debug("Non-valid name entered");
            return false;
        }
        isValid = InputDataCheck.inputCheck(password, RegexContainer.REGEX_PASSWORD);
        if (!isValid) {
//            log.debug("Non-valid password entered");
            return false;
        }
        return true;
    }
}
