<div class="row">
	<g:each in="${partidos}" var="p" status="i">
		<div class="col-md-12">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h2>Jornada ${i+1}</h2>
				</div>
  				<div class="panel-body">
  					<div class="row">
  						<g:each in="${p}" var="partido">
							<div class="col-xs-6 panel panel-default">
								<div class="panel-body row">
									<div class="col-xs-12">
										<div class="row">
											<div class="col-xs-4">
												<img src="${partido.local_shield}" class="img img-responsive">
											</div>
											<div class="col-xs-4">
												<p class="text-center lead"><strong>${partido.result}</strong></p>
											</div>
											<div class="col-xs-4">
												<img src="${partido.visitor_shield}" class="img img-responsive">
											</div>
										</div>
									</div>
									<hr>
									<div class="col-xs-12">
										<div class="row">
											<div class="col-xs-5">
												<div class="pull-left"><span class="glyphicon glyphicon-time"></span>: ${partido.hour}:${partido.minute}</div>
											</div>
											<div class="col-xs-7">
												<div class="pull-right"><span class="glyphicon glyphicon-calendar"></span>: ${partido.date}</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</g:each>
					</div>
  				</div>
  			</div>
		</div>
	</g:each>
</div>
