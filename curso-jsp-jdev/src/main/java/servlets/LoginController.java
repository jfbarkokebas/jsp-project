package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.SingleConnectionBD;
import dao.LoginRepository;
import model.LoginModel;

@WebServlet("/servletlogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SingleConnectionBD connection = new SingleConnectionBD();
	LoginRepository dao = new LoginRepository();

	public LoginController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url = request.getParameter("url");

		LoginModel userLogin = new LoginModel();

		try {
			if (login != null && !login.isEmpty() || senha != null && !senha.isEmpty()) {
				userLogin.setLogin(login);
				userLogin.setSenha(senha);

				if (dao.validarAutenticacao(userLogin)) {

					request.getSession().setAttribute("usuario", userLogin.getNome());

					if (url == null || url.equalsIgnoreCase("null")) {
						url = "principal/principal.jsp";
					}

					RequestDispatcher encaminhar = request.getRequestDispatcher(url);
					encaminhar.forward(request, response);

				} else {
					RequestDispatcher encaminhar = request.getRequestDispatcher("/index.jsp");
					request.setAttribute("msg", "Usuário ou senha inválidos.");
					encaminhar.forward(request, response);
				}

			} else {
				RequestDispatcher encaminhar = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Precisa preencher todos os campos.");
				encaminhar.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
