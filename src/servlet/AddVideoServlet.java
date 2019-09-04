package servlet;

/**
 * @author janith
 *
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Video;
import service.VideoServiceImpliment;
import service.IVideoService;


/**
 * Servlet implementation class AddVideoServlet
 */
@WebServlet("/AddVideoServlet")
public class AddVideoServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
      
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public AddVideoServlet() {
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
		
		
	
		Video video = new Video();
		
		video.setVideoTitle(request.getParameter("videoTitle"));
		video.setCategory(request.getParameter("Category"));
		video.setRunningTime(request.getParameter("runningTime"));
		video.setUploadDate(request.getParameter("Language"));
		video.setLanguage(request.getParameter("UploadDate"));
		video.setVideoDescription(request.getParameter("videoDescription"));

		IVideoService iVideoService  = new VideoServiceImpliment();
		iVideoService.addVideo(video);

		request.setAttribute("video", video);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListVideos.jsp");
		dispatcher.forward(request, response);

	}

}
