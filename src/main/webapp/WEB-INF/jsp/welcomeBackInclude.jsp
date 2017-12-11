<sec:authorize access="hasRole('ROLE_USER')">
	<c:if test="${pageContext.request.userPrincipal.name != null }">
		<div class="container-fluid">
			<h3 id="userId">Welcome back,
				${pageContext.request.userPrincipal.name}</h3>
		</div>
	</c:if>
</sec:authorize>