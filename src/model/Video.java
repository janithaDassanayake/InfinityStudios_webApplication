package model;

public class Video {
	
		private String videoId;
		private String videoTitle;
		private String Category;
		private String runningTime;
		private String Language;
		private String UploadDate;
		private String videoDescription;
		
		
		public String getVideoId() {
			return videoId;
		}
		public void setVideoId(String videoId) {
			this.videoId = videoId;
		}
		public String getVideoTitle() {
			return videoTitle;
		}
		public void setVideoTitle(String videoTitle) {
			this.videoTitle = videoTitle;
		}
		public String getCategory() {
			return Category;
		}
		public void setCategory(String Category) {
			this.Category = Category;
		}
		public String getRunningTime() {
			return runningTime;
		}
		public void setRunningTime(String runningTime) {
			this.runningTime = runningTime;
		}
		public String getLanguage() {
			return Language;
		}
		public void setLanguage(String Language) {
			this.Language = Language;
		}
		public String getUploadDate() {
			return UploadDate;
		}
		public void setUploadDate(String UploadDate) {
			this.UploadDate = UploadDate;
		}
		public String getVideoDescription() {
			return videoDescription;
		}
		public void setVideoDescription(String videoDescription) {
			this.videoDescription = videoDescription;
		}
		
		
		@Override
		public String toString() {
			return "Video [videoId=" + videoId + ", videoTitle=" + videoTitle + ", Category=" + Category
					+ ", runningTime=" + runningTime + ", Language=" + Language + ", UploadDate=" + UploadDate
					+ ", videoDescription=" + videoDescription + "]";
		}
	
	

		
}
