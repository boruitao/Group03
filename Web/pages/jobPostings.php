<?php
include ('session.php');
require_once __DIR__ . '\..\model\ManagementSystem.php';
require_once __DIR__ . '\..\model\JobPosting.php';
require_once __DIR__ . '\..\model\Course.php';
require_once __DIR__ . '\..\persistence\PersistenceTAMAS.php'?>
<html lang="en">

<head>


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>DashBoard</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
</head>

<body>
	<div id="wrapper">
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">

				<div class="navbar-header">
					<a class="navbar-brand" href="dashboard.php">TAMAS</a>
				</div>
				<h6 class="welcome">Welcome
                            <?php echo $login_session; ?>
                        </h6>
				<h6 class="welcome">
					<a href="logout.php">Sign Out</a>
				</h6>
				<ul class="nav" id="side-menu">
					<li><a href="dashboard.php"><i class="fa fa-dashboard fa-fw"></i>
							Dashboard</a></li>
					<li><a href="viewAllJObPostings.php"><i class="fa fa-dashboard fa-fw"></i>
							All Job Postings</a></li>
					<!-- 					<li><a href="courses.php"><i class="fa fa-dashboard fa-fw"></i> Job -->
					<!-- 							Postings</a></li> -->
				</ul>
			</div>
		</div>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Add Job Postings</h1>
				</div>
			</div>
			<div class="row">
				<div class="box box-info col-lg-12">
					<div class="box-header with-border"></div>
					<!-- 					$aJobTitle, $aSubmissionDeadline, $aPerferredExperience, $aNumNeeded, $aHourRate, $aCourse -->
					<div class="box-body">

						<form action="addJobPosting.php" method="post">
							<label>Select a course:</label>			<?php
							if (isset ( $_SESSION ['errorCourse'] ) && ! empty ( $_SESSION ['errorCourse'] )) {
								echo "*" . $_SESSION ["errorCourse"];
							}
							?>
							<select name="courses" class="form-control" id="">
								<option value="COMP 251">COMP 251</option>
								<option value="ECSE 321">ECSE 321</option>
								<option value="ECSE 211">ECSE 211</option>

							</select> <br>
							<p>
								<label>Job Title: </label><?php
								if (isset ( $_SESSION ['errorJobTitle'] ) && ! empty ( $_SESSION ['errorJobTitle'] )) {
									echo "*" . $_SESSION ["errorJobTitle"];
								}
								?>
								<select name="jobTitle" class="form-control" id="">
									<option value="TA">TA</option>
									<option value="Grader">Grader</option>
								</select>

							</p>

							<p>
								<label>Dead Line: </label> <input class="form-control"
									type="date" name="deadLine"
									value="<?php echo date('Y-m-d'); ?>" /> <span class="error">
			<?php
			if (isset ( $_SESSION ['errorDeadLine'] ) && ! empty ( $_SESSION ['errorDeadLine'] )) {
				echo "*" . $_SESSION ["errorDeadLine"];
			}
			?>
			</span>
							</p>
							<div>
								<label>Perferred Experience: </label>
								<textarea class="form-control" name="perferredExperience"></textarea>
								<span class="error">
			<?php
			if (isset ( $_SESSION ['errorPerferredExperience'] ) && ! empty ( $_SESSION ['errorPerferredExperience'] )) {
				echo "*" . $_SESSION ["errorPerferredExperience"];
			}
			?>
			</span>
							</div>

							<p>
								<label>Number needed: </label> <input class="form-control"
									type="text" name="numberNeeded" value="" /> <span class="error">
			<?php
			if (isset ( $_SESSION ['errorNumberNeeded'] ) && ! empty ( $_SESSION ['errorNumberNeeded'] )) {
				echo "*" . $_SESSION ["errorNumberNeeded"];
			}
			?>
			</span>
							</p>
							<p>
								<label>Hourly Rate: </label> <input class="form-control"
									type="text" name="hourlyRate" value="" /> <span class="error">
			<?php
			if (isset ( $_SESSION ['errorHourlyRate'] ) && ! empty ( $_SESSION ['errorHourlyRate'] )) {
				echo "*" . $_SESSION ["errorHourlyRate"];
			}
			?>
			</span>
							</p>
							<p>
								<input class="btn btn-sm btn-info btn-flat pull-left"
									type="submit" value='Publish'>
						
						</form>

						<br> <br> <br>
							<?php
// 							$pm = new PersistenceTAMAS ();
// 							$rm = $pm->loadDataFromStore ();
// 							foreach ( $rm->getJobPostings () as $jobPostings ) {
// 								echo "<p>" . $jobPostings->getJobTitle () . " " . $jobPostings->getCourse ()->getCourseCoude () . "</p>";
// 							}
// 							?>
					</div>
				</div>


			</div>

		</div>
	</div>
</body>

</html>