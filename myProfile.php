<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>My Profile</title>
  <meta name="description" content="The HTML5 Herald">
  <meta name="author" content="SitePoint">

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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

  <script type="text/javascript">
  function setFocus()
  {
    document.getElementById("fullName").focus();   // access element of document with id="taskdesc" and set focus on it

  }
  </script>

  <style>
  .absolutepositioning {
    position: absolute;
    left: 10px;
  }

  .titleBorder{
    border: 5px solid black;
    outline-style: solid;
    outline-color: LimeGreen;
    outline-width: 10px;
}
  </style>


  <style>
      .error {
         color: red;
         font-style: italic;
      }
    </style>

</head>

<body onload = "setFocus();">
  <script src="resources/js/scripts.js"></script>

  <nav> <!--sitemap!-->
    <ul>
      <li><a href="index.php">HoosAround</a></li>
      <li><a href="match-me.html">Match Me</a></li>
      <li><a href="my-matches.html">My Matches</a></li>
      <li style="float:right"><a class = "current" href="myProfile.php"><img src="http://www.freeiconspng.com/uploads/profile-icon-9.png" width=20 height=20></a></li>
      <li style="float:right"><a href="myProfile.php">My Profile</a></li>
    </ul>
  </nav>

  <h3 align="center" class="titleBorder"><b>Design Your Profile!</b><br></h3>


  <form action="<?php $_SERVER['PHP_SELF'] ?>" method="post" > <!--abs positioning gives padding!-->
    <dl>
       <dt>Name:</dt>
       <dd><input type="text" name="name"
                value="<?php if (isset($_POST['name'])) echo $_POST['name']; ?>" /></dd>
       <dt>Major </dt>
       <dd><input type="text" name="major"
                value="<?php if (isset($_POST['major'])) echo $_POST['major']; ?>" /></dd>
       <dt>Hobbies:</dt>
       <dd><textarea rows="5" cols="20" name="hobbies"
                value="<?php if (isset($_POST['hobbies'])) echo $_POST['hobbies']; ?>"></textarea> </dd>
      <dt>Year</dt>
      <dd><input type="text" name="year"
               value="<?php if (isset($_POST['year'])) echo $_POST['year']; ?>"/> </dd>

    </dl>

    <input type="submit" value="Submit" />

  </form>

  <?php
    $name = $major = $hobbies = $year = NULL;

    if ($_SERVER['REQUEST_METHOD'] == 'POST')
    {
       if (empty($_POST['name']))
          echo "Please enter your name <br />";
       else
          $name = trim($_POST['name']);

       if (empty($_POST['major']))
          echo "Please enter your major <br />";
       else
          $major = trim($_POST['major']);

       if (empty($_POST['hobbies']))
          echo "Please enter your hobbies <br />";
       else
          $hobbies = trim($_POST['hobbies']);

       if (empty($_POST['year']))
          echo "Please enter your year <br />";
       else
          $year = trim($_POST['year']);
    }

    if ($name != NULL && $major != NULL && $hobbies != NULL && $year)
    {
       echo "Thanks for submitting your profile, $name <br />";
    }

  ?>
    <!--Full Name:<br>
    <input type="text" id="fullName" name="fullName">
    <span class="error" id="fullName-note"></span>

    $nameLength = $_POST(["fullName"]);
    <?php
    if(isset($_POST['fullName']) && strlen($nameLength) > 4){
      echo "Thank you for inputting your name correctly!";
    }
    elseif (empty($_POST['fullName']) || strlen($nameLength) <= 4){
      echo "Please input your name properly.";
    }
    ?>

    <br>
    Major:<br>
    <select name="major"> <br>
      <option value="">Please Select a Major</option>
      <option value="CS">Computer Science</option>
      <option value="CPE">Computer Engineering</option>
      <option value="EE">Electrical Engineering</option>
      <option value="ME">Mechanical Engineering</option>
      <option value="BME">Biomedical Engineering</option>
      <option value="CE">Civil Engineering</option>
      <option value="AE">Aerospace Engineering</option>
      <option value="SE">Systems Engineering</option>
    </select>
    <br/>
    <?php
      if(!isset($_POST['major'])){
        echo "Please Select a Major <br/>";
      }
    ?>



    Favorite Hobbies: <br>
    <input type="text" name="favoriteHobbies"> <br>
    <?php
      if(isset($_POST['favoriteHobbies']))
      {
        $hobbyStr = $_POST["favoriteHobbies"];
        $hobbyArr = explode(",", $hobbyStr);
        $arraySize = 0;
        foreach($hobbyArr as $value){
          $arraySize = $arraySize + 1;
        }
        echo "Your listed activities include";
        for($count = 0; $count < $arraySize; $count++){
          echo $hobbyArr[$count] . ",";
        }
      }


    ?>


    <br>


    Year: <br>
    <input type="radio" name="year" value="1st">1st Year<br>
    <input type="radio" name="year" value="2nd"> 2nd Year<br>
    <input type="radio" name="year" value="3rd"> 3rd Year <br>
    <input type="radio" name="year" value="4th"> 4th Year <br>
    <br> -->


    <!-- <div class="container">

    <div class="form-group">
        <label for="socialMedia">Add Your Social Media so People Can Get to Know You!</label>
        <input type="text" id="socialMedia" class="form-control" name="SM" />
        <span class="error" id="socialMedia-note"></span>
    </div>

    <input type="button" class="btn btn-submit" id="addLink" value="Add Link" onclick="addRow()"/> -->

    <!-- <div id="links">
      <table id="linkTable" class="table" >
        <thead>   <!-- set table headers -->
          <!-- <tr>
            <th>Social Media Link</th>
            <th>(Remove)</th>
          </tr>
        </thead>
      </table>
    </div>

  </div> -->




  <script>
  document.getElementById("fullName").addEventListener("mouseover", formInputValidation);
  function formInputValidation(){ <!--attempted input validation!-->

    var fullNameVal = document.getElementById("fullName").value;
    if (fullNameVal === '')    // check if appropriate data are entered
    {
       document.getElementById("fullName").focus();
       document.getElementById("fullName-note").innerHTML = "Please enter your Full Name";
    }
    else
    {
     document.getElementById("fullName-note").innerHTML = "";
}

  </script>



</body>
</html>
