<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
   Welcome ${name} <br>
   You can now <a href="/list-todos" class="btn btn-info">View Statement</a> (mini-statement of last 5 transactions)
   <br>
   You can initiate  <a href="/add-todo" class="btn btn-success">new transaction</a>
</div>
<%@ include file="common/footer.jspf"%>