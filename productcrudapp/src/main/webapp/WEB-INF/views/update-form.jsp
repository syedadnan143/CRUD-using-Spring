<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="./base.jsp" %>
</head>
<body>
<div class="col-md-6 offset-md-3">
<h1 class="text-center mb-3">update your details</h1>
<form action= "${pageContext.request.contextPath}/handle-product" method="post">
<input type="text"  value="${product.id}" name="id" >
<div class="form-group">
<label for="name">product name</label><input type="text" 
class="form-control" id="name" aria-describedby="emailHelp"
name="name" placeholder="Enter the product name"
value="${product.name}">
</div>
<div class="form-group">
<lable for="description">Product Description</lable>
<textarea class="form-control"
 name="description"
  id="description"
   rows="5"
   placeholder="Enter the product description" >${product.description}
   </textarea>
   
</div>
<div class= "form-group">
<label for="price">Product Price</label>

 <input type="text" 
 placeholder="Enter Product Price"
  name= "price"
   class="form-control" 
   id="price" value="${product.price}">
</div>
<div class="container text-center">
<a href="${pageContext.request.contextPath }/" 
class="btn btn-outline-danger">Back</a>
<button type= "submit" class="btn btn-primary">update</button>
 </div>
 </form>
</div>
</body>
</html>