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
 * Servlet implementation class UpdateVideoServlet
 */
@WebServlet("/UpdateVideoServlet")
public class UpdateVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVideoServlet() {
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

		Video video=new Video();
		String videoId = request.getParameter("videoId");	
		
		video.setVideoId(videoId);
		
		video.setVideoTitle(request.getParameter("videoTitle"));
		video.setCategory(request.getParameter("Category"));
		video.setRunningTime(request.getParameter("runningTime"));
		video.setLanguage(request.getParameter("Language"));
		video.setUploadDate(request.getParameter("UploadDate"));
		video.setVideoDescription(request.getParameter("videoDescription"));
		
		
		IVideoService iVideoService = new VideoServiceImpliment();
		iVideoService.updateVideo(videoId, video);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListVideos.jsp");
		dispatcher.forward(request, response);

		
	}

}
