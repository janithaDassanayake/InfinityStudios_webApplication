/**
 * 
 */
package service;

import java.util.ArrayList;
import java.util.logging.Logger;

import model.Video;

/**
 * @author janith
 *
 */
public interface IVideoService {

	
	//logger will Initialized
	public static final Logger log = Logger.getLogger(IVideoService.class.getName());


	/**
	 * Add video for video table
	 * @param video
	 */
	public void addVideo(Video video);

	/**
	 * Get a particular video
	 * 
	 * @param videoID
	 * @return Video
	 */
	public Video getVideoByID(String videoId);
	
	/**
	 * Get all list of video
	 * 
	 * @return ArrayList<Video>
	 */
	public ArrayList<Video> getVideos();
	
	/**
	 * Update existing video
	 * @param videoID
	 * @param video
	 * 
	 * @return
	 */
	public Video updateVideo(String videoId , Video video);

	/**
	 * Remove existing Video
	 * 
	 * @param videoID
	 */
	public void removeVideos(String videoId);

}

	
	
	

