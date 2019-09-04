
package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import model.Video;
import util.CommonConstants;
import util.CommonUtil;
import util.DBConnectionUtil;
import util.QueryUtil;



/**
 * @author janith
 *
 */
public class VideoServiceImpliment implements IVideoService {

	public static final Logger log = Logger.getLogger(VideoServiceImpliment.class.getName());


	private static Connection connection;

	
	private static Statement statement;

	
	

	static{
		//create table or drop if exist
		createVideoTable();
	}
	
	
/* ************************************************************** */
	
	private PreparedStatement preparedStatement;
	
	
	
	public static void createVideoTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			// Create new videos table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	
	
	
	/***********************************************************************************************/
	

	
	@Override
	public void addVideo(Video video) {
		// TODO Auto-generated method stub
		
			String videoId=CommonUtil.generateIDs(getVideoIDs());
		
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in videoQuery.xml file and use
			 * insert_video key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_videos));
			connection.setAutoCommit(false);
			
			//Generate video IDs
			video.setVideoId(videoId);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, video.getVideoId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, video.getVideoTitle());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, video.getCategory());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, video.getRunningTime());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, video.getUploadDate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, video.getLanguage());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, video.getVideoDescription());
			
			// Add video
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
	}

	
	
	
	
	
	
	@Override
	public Video getVideoByID(String videoId) {
		// TODO Auto-generated method stub
		return actionOnVideo(videoId).get(0);
	}

	@Override
	public ArrayList<Video> getVideos() {
		// TODO Auto-generated method stub
		return actionOnVideo(null);
	}

	
	/*****************************************************************/	
	@Override
	public Video updateVideo(String videoId, Video video) {
		// TODO Auto-generated method stub
		
		if (videoId != null && !videoId.isEmpty()) {
			/*
			 * Update empvideo loyee query will be retrieved from videoQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_video));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, video.getVideoTitle());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, video.getCategory());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, video.getRunningTime());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, video.getUploadDate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, video.getLanguage());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, video.getVideoDescription());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, video.getVideoId());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated videoId
		return getVideoByID(videoId);
	}

	
	
	
	/*****************************************************************/
	
	
	@Override
	public void removeVideos(String videoId) {
		// TODO Auto-generated method stub
	
		
		if (videoId != null && !videoId.isEmpty()) {
			/*
			 * Remove videoId query will be retrieved from videoQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_videos ));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, videoId);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
		
	}

	
	/****************************************************************/
	
	private ArrayList<Video>actionOnVideo(String videoId) {

		ArrayList<Video>videoList = new ArrayList<Video>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching video it checks whether video ID is
			 * available
			 */
			if (videoId != null && !videoId.isEmpty()) {
				/*
				 * Get video by ID query will be retrieved from
				 * VideoQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_videos));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, videoId);
			}
			
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_videos));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Video video = new Video();
				video.setVideoId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				video.setVideoTitle(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				video.setCategory(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				video.setRunningTime(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				video.setUploadDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				video.setLanguage(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				video.setVideoDescription(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				videoList.add(video);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return videoList;
	}
	
	
	

	
	/*********************************************************/
	
	
	private ArrayList<String>getVideoIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of video IDs will be retrieved from videoQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_video_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
	
	
	
	
}
