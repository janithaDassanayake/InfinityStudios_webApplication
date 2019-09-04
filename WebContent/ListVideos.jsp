<%@page import="java.util.ArrayList"%>
<%@page import="model.Video"%>
<%@page import="com.sun.media.jfxmedia.control.VideoDataBuffer"%>
<%@page import="service.VideoServiceImpliment"%>
<%@page import="service.IVideoService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Infinity Clips</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

	<div id="wrapper">
		<!-- Navigation -->
        	<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            	<div class="navbar-header">

                	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    		<span class="sr-only">Toggle navigation</span>
                    		<span class="icon-bar"></span>
                    		<span class="icon-bar"></span>
                    		<span class="icon-bar"></span>
                	</button>

	                <a class="navbar-brand" href="index.jsp">Infinity clips</a
                ></div>
            	<!-- /.navbar-header -->

            	<ul class="nav navbar-top-links navbar-right">
                	<li class="dropdown">
                    		<a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    	</a>
                <ul class="dropdown-menu dropdown-messages">
                        <li>
                        	<a href="https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin">
                        	<div>
                        		<strong>Amila Sampath</strong>
                                	<span class="pull-right text-muted">
                                	<em>Yesterday</em>
                                	</span>
                        	</div>
                        	<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                        	</a>
                        </li>

                        <li class="divider"></li>
                        <li>
                            	<a href="https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin">
                                <div>
                                    	<strong>Imashi Jayasekara</strong>
                                    	<span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    	</span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            	</a>
                        </li>

                        <li class="divider"></li>
                        <li>
                            	<a href="https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin">
                                <div>
                                    	<strong>Samila Manujitha</strong>
                                    	<span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    	</span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            	</a>
                        </li>

                        <li class="divider"></li>
                        <li>
                            	<a class="text-center" href="https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            	</a>
                        </li>
		</ul>
                <!-- /.dropdown-messages -->
                </li>
                
		
		<!-- /.dropdown -->
                

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-rocket fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        
                        <li>
                            <a href="https://twitter.com/login?lang=en">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> Twitter
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Gmail
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="https://www.youtube.com/">
                                <div>
                                    <i class="fa  fa-youtube-play fa-fw"></i> YouTube Play
                                    <span class="pull-right text-muted small">Watch Now!</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="https://www.facebook.com/">
                                <div>
                                    <i class="fa  fa-facebook-square  fa-fw"></i> Facebook
                                </div>
                            </a>
                        </li>
						<li class="divider"></li>
                        <li>
                            <a href="https://www.mediafire.com/">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Upload Now
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
<!------------------------------------------------------------------------------------------------------------------------------------------>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="home.jsp"><i class="fa fa-dashboard fa-fw"></i>Home</a>
                        </li>
                        <li>
                            <a href="workingWindow.jsp"><i class="fa fa-comments fa-fw"></i>Insert window</a>
                        </li>
                        
                        <li>
                            <a href="ListVideos.jsp"><i class="fa fa-users fa-fw"></i>Show Video data</a>
                        </li>
                        <li>
                            <a href="GetVideo.jsp"><i class="fa fa-edit fa-fw"></i> Edit Video data</a>
                        </li>
                        <li>
                            <a href="mainGUI.jsp"><i class="fa fa-bell fa-fw"></i> Main GUI</a>
                        </li>
                        <li>
                            <a href="icons.jsp"><i class="fa fa-cube fa-fw"></i> Icons</a>
                        </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
<!------------------------------------------------------------------------------------------------------------------------------------------>
       
       
       
       
       
       
       
       
       
       
       
       
       
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">video List</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Video information
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                    	<th>Video ID</th>
                                        <th> video Title</th>
                                        <th>Category</th>
                                        <th>Running Time</th>
                                        <th>Language</th>
                                        <th>Upload Date</th>
                                        <th> video Description</th>
                                       
                                    </tr>
                                </thead>
                  
                  
           <%
          
            IVideoService iVideoService = new VideoServiceImpliment();
			ArrayList<Video>arrayList=iVideoService.getVideos();
			
			for(Video video : arrayList){
			
			%>              
                                
                                
                                
          <tbody>
                <tr class="odd gradeX">
         
				<td> <%=video.getVideoId() %> </td>
				<td> <%=video.getVideoTitle() %> </td>
				<td> <%=video.getCategory() %> </td>
				<td> <%=video.getRunningTime() %> </td>
				<td> <%=video.getLanguage() %> </td>
				<td> <%=video.getUploadDate() %> </td>
				<td> <%=video.getVideoDescription() %> </td>
			
				
				<td> 
				
				<form method="POST" action="GetVideoServlet">
				<input type="hidden" name="videoId" value="<%=video.getVideoId()%>"/>
				 <input type="submit" value= "Select video" class="select-button" /> 
				 
				 
				 </form>
				 </td>	
				 
				</tr>			
			<%	
			   }
            %>     
                                        
                                        
                                        
                       
         </tbody>
                            </table>
                            
                            
 <!------------------------------------------------------------------------------------------------------------------------------------------>
                            <!-- /.table-responsive -->
                            <div class="well">
                              
                                
                                <a class="btn btn-default btn-lg btn-block" target="_blank" href="mainGUI.jsp">Back to GUI</a>
                            
                          
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
           
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>

</body>

</html>
