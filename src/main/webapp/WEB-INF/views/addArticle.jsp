<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Add new article</title>
    </head>

    <body>
        <h2>Welcome</h2>
        <form method="GET" action="/aap/articles/new/add" id="frmAddArticle" name ="frmAddArticle">
            <input type="button"  onclick="location.href='/aap/articles/all'" value="Back" >
        	<br>
        	<textarea id="name_text" name="name_text" cols="50" rows="1" required="required">${article.name}</textarea>
        	<br>
        	<textarea id="content_text" name="content_text" cols="50" rows="5" required="required">${article.content}</textarea>
        	<br>
        	<textarea id="category_text" name="category_text" cols="20" rows="1" required="required">${article.category}</textarea>
        	<br>
            <input type="submit" class="button" value="Save changes">
        </form>
    </body>
</html>