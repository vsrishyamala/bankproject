<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h2>Fund Transfer</h2>
	<form:form method="post" commandName="todo">
	<form:hidden path="id" />
	<fieldset class="field-group">
	<form:label path="desc">Amount: </form:label><form:input path="desc" type="text" class="form-control" required="required" />
	<form:errors path="desc" cssClass="text-warning" />
	</fieldset>
	<fieldset class="field-group">
	<form:label path="targetDate">Transaction Date: </form:label><form:input path="targetDate" type="text" class="form-control" required="required" />
	<form:errors path="targetDate" cssClass="text-warning" />
	</fieldset>
	<fieldset class="field-group">
	<form:label path="purpose">Purpose: </form:label><form:input path="purpose" type="text" class="form-control" required="required" />
	<form:errors path="purpose" cssClass="text-warning" />
	</fieldset><br><br> 
	<input type="submit" class="btn btn-success btn-lg" value="submit">
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>