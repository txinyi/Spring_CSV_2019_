<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
      <title>File Uploading Form</title>
   </head>
   
   <body>
      <h3>File Upload:</h3>
      Select a file to upload: <br />
      <form action="/uploadToDB" method="post" enctype="multipart/form-data">
         <input type="file" name="file" id="fileupload" size="1" required="required" />
         <br /><br />
         <input type="submit" value="Upload File" />
      </form>
   </body>
</html>