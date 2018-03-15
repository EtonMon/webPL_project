<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>HoosAround</title>
  <meta name="description" content="The HTML5 Herald">
  <meta name="author" content="SitePoint">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- the width=device-width part sets the width of the page to follow
          the screen-width of the device (which wil vary depending on the device)
  !-->

  <link rel="stylesheet" href="resources/css/styles.css?v=1.0">

  <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
  <![endif]-->

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <script>
$(document).ready(function(){
    $("tr").hover(function(){
        $(this).css("background-color", "Aqua");
        }, function(){
        $(this).css("background-color", "white");
    });
});
</script>

  <style>
  table {
      font-family: Futura;
      border-collapse: collapse;
      width: 85%;
  }

  td, th {
      border: 1px solid black;
      text-align: left;
      padding: 8px;
  }
  </style>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
.vertical-menu {
    width: 200px;
    height: 150px;
    overflow-y: auto;
}

.vertical-menu a {
    background-color: #eee;
    color: black;
    display: block;
    padding: 12px;
    text-decoration: none;
}

.vertical-menu a:hover {
    background-color: #ccc;
}

.vertical-menu a.active {
    background-color: #4CAF50;
    color: white;
}
</style>
<!-- https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_vertical_menu_scroll !-->
</head>

<body>
  <?php
    function getPeople(){

      $names = Array("Thomas Jefferson", "John Doe", "Jane Smith", "Mary Lou", "Jeffrey Swallows");
      $majors = Array("Thomas Jefferson" => "Computer Science", "John Doe" => "Anthropology", "Jane Smith" => "Mathematics", "Mary Lou" => "English", "Jeffrey Swallows" => "Medieval Literature");
      $hobbies = Array("Thomas Jefferson" => "Commenting on Stack Overflow", "John Doe" => "Quality Antiquing", "Jane Smith" => "Bowling with Railings", "Mary Lou" => "Writing Poetry", "Jeffrey Swallows" => "Live Action Role Playing Games");
      $years = Array("Thomas Jefferson" => "4th", "John Doe" => "1st", "Jane Smith" => "3rd", "Mary Lou" => "3rd", "Jeffrey Swallows" => "2nd");

      foreach($names as $name){
        echo "<tr>
          <th>
            <a href=\"\">$name</a>
          </th>
          <td>$majors[$name]</td>
          <td>$hobbies[$name]</td>
          <td>$years[$name] Year</td>
        </tr>";
      }
    }
  ?>
  <script src="resources/js/scripts.js"></script>
  <nav>
    <ul>
      <li><a class="current" href="index.php">HoosAround</a></li>
      <li><a href="match-me.html">Match Me</a></li>
      <li><a href="my-matches.html">My Matches</a></li>
      <li style="float:right"><a href="myProfile.php"><img src="http://www.freeiconspng.com/uploads/profile-icon-9.png" width=20 height=20></a></li>
      <li style="float:right"><a href="myProfile.php">My Profile</a></li>

    </ul>
  </nav>

  <h1>People Nearby</h1>
  <table align = "center" class= "vertical-menu">
    <tr class = "active">
      <th align="center">Name</th>
      <th>Major</th>
      <th>Favorite Hobby</th>
      <th>Year</th>
    </tr>

    <?php
      getPeople();
    ?>
    <!-- <tr>
      <th>
        <a href="https://www.google.com/">Thomas Jefferson</a>
      </th>
      <td>Computer Science</td>
      <td>Commenting on Stack Overflow</td>
      <td>4th Year</td>
    </tr>

    <tr>
      <th>
        <a href="https://www.google.com/">John Doe</a>
      </th>
      <td>Anthropology</td>
      <td>Quality Antiquing</td>
      <td>1st Year</td>
    </tr>

    <tr>
      <th>
        <a href="https://www.google.com/">Jane Smith</a>
      </th>
      <td>Mathematics</td>
      <td>Bowling with Railings</td>
      <td>3rd Year</td>
    </tr>

    <tr>
      <th>
        <a href="https://www.google.com/">Mary Lou</a>
      </th>
      <td>English</td>
      <td>Writing Poetry</td>
      <td>3rd Year</td>
    </tr>

    <tr>
      <th>
        <a href="https://www.google.com/">Jeffrey Swallows</a>
      </th>
      <td>Medieval Literature</td>
      <td>Live Action Role Playing Games</td>
      <td>2nd Year</td>
    </tr> -->
  </table>

</body>
</html>