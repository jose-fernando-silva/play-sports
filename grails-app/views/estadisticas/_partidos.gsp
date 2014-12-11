<div class="row">
	<div class="col-xs-12">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h2>Partidos de la jornada ${jornada} de ${liga.name} </h2>
			</div>
			<div class="container">
  				<div class="row panel-body">
  					<g:each in="${partidos}" var="partido">
						<div class="col-xs-6 col-md-4 col-lg-4 panel panel-default">
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
</div>
