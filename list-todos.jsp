

<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="container">
	<p class="lead">Hi ${name}</p>
	    <br>
	   
	   <table class="table table-striped">
	   	<caption>Your Last 5 transactions are:</caption>
	   	<thead>
	   		<tr>
	   			<th>Amount</th>
	   			<th>Transaction Date</th>
	   			<th>Purpose</th>
	   			<th></th>
	   		</tr>
	   	</thead>
	   	<tbody>
	   	<% int counter = 1; %>
	   	<c:forEach items = "${todos }" var="todo" >
	   	<% counter++; %>
	   		<tr>
	   			<td>${todo.desc }</td>
	   			<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
	   			<td>${todo.purpose }</td>
	   			<td>
	   			<td>
	   		</tr>
	   	<% if(counter > 5 ) break; %>
	   </c:forEach>
	   	</tbody>
	   </table>
	   
	   
	   
	   <br>
	   <a class="btn btn-success btn-lg" href="/add-todo">New Transaction</a>
   </div>
  <%@ include file="common/footer.jspf"%>