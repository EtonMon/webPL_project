<?php



/* -------------------------------------- */
// if the request from ng-app is a get request (url attached with param-value),
// we can retrieve a specific param from the $_GET object directly

  $time = $_GET["time"];
  if ($time != ""){
    echo "Thank you for submitting your information!"
  }


?>
