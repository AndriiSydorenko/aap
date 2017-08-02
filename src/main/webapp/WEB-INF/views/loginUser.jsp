<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Login new user</title>
    </head>

    <body>
        <form method="GET" action="/aap/login/confirm">
          <div class="imgcontainer">
            <img src="img_avatar2.png" alt="Avatar" class="avatar">
          </div>

          <div class="container">
            <label><b>Username</b></label>
            <input id="login_text" name="login_text" type="text" placeholder="Enter Username" required="required">${login_text}</input>

            <br>
            <label><b>Password</b></label>
            <input id="password_text" name="password_text" type="password" placeholder="Enter Password"  required="required">${password_text}</input>

            <input type="submit" class="button" value="Login">
          </div>
        </form>
    </body>
</html>