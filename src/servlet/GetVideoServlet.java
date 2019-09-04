package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Video;
import service.IVideoService;
import service.VideoServiceImpliment;
/**
 * Servlet implementation class GetVideoServlet
 */
@WebServlet("/GetVideoServlet")
public class GetVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		

		response.setContentType("text/html");

		String videoId = request.getParameter("videoId");			
		IVideoService iVideoService = new VideoServiceImpliment();
		Video video = iVideoService.getVideoByID(videoId);

		request.setAttribute("video", video);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GetVideo.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
