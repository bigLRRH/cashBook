<%
String username = request.getParameter("username");
String password= request.getParameter("password");
String mobileNumber= request.getParameter("mobileNumber");
out.println(username);
out.println(password);
out.println(mobileNumber);
%>