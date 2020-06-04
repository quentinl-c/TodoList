<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="header.jsp"%>

<body>
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="large-12 cell">
                <h3>Todo List</h3>
                <table>
                    <tr>
                    	<th>Task</th>
                    	<th></th>
                    </tr>
                    <c:forEach items="${tasks}" var="task">
                    	<tr><td>${task.taskName}</td>
                        	<td class="right"><form accept-charset="UTF-8" action="TaskDone" method="post" >
                        		<input type="hidden" name="taskId" value='${task.id}'>
                            	<input type="submit" value="Done" class="alert button"> </form>
                        	</td>
                    	</tr>
                    </c:forEach>
                </table>
                <form action="AddTask" method="post">
                	<label>
                		One more thing to do ...
                		<input name="taskName" type="text" placeholder="do my homework">
                	</label>
                	<input type="submit" value="Add new task" class="success button">
                </form>
            </div>
        </div>
    </div>
</body>
</html>