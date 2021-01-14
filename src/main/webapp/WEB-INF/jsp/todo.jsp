<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
    <p>Add todo for ${name}</p>
    <form:form method="POST" modelAttribute="todo">
        <form:hidden path="id"/>
        <fieldset class="form-group">
            <form:label path="description">Description:</form:label>
            <form:input path="description" type="text" name="description" class="form-control" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="targetDate">Target Date:</form:label>
            <form:input path="targetDate" type="text" name="targetDate" class="form-control" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>
        <button class="btn btn-success" type="submit">Add</button>
    </form:form>
</div>

<%@ include file="common/footer.jspf"%>
