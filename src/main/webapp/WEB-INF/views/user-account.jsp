<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>


<div class="jumbotron">



	<c:if test="${not empty user.cart}">
		<!-- Nav tabs -->
		<ul class="nav nav-tabs">

			<li><a href="#blog_${user.cart.id}" data-toggle="tab"><c:out
						value="${user.cart.name}" /></a></li>

		</ul>

		<!-- Tab panes -->
		<div class="tab-content">

			<div class="tab-pane" id="blog_${user.cart.id}">
				<h4>
					<c:out value="${user.cart.name}" />
				</h4>
				<p>

					<a href="<spring:url value="/blog/remove/${user.cart.id}.html" />"
						class="btn btn-danger triggerRemove">remove Cart</a>

					<c:out value="${user.cart.name}" />
				</p>

				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>date</th>
							<th>item</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${user.cart.products}" var="item">
							<tr>

								<td><strong> <a
										href="<c:out value="${item.product_name}" />" target="_blank">
											<c:out value="${item.price}" /> <c:out value="${item.type}" />
											<c:out value="${item.category}" /> <c:out
												value="${item.brand}" />
									</a>
								</strong> <br ></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>


		<!-- Modal -->
		<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Remove blog</h4>
					</div>
					<div class="modal-body">Really remove?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<a href="" class="btn btn-danger removeBtn">Remove</a>
					</div>
				</div>
			</div>
		</div>
	</c:if>