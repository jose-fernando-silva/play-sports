<div class="container">
	<div class="row">
		<div class="col-xs-11">
			<div class="panel panel-default">
  				<div class="panel-heading">
  					<h1>Bienvenido <strong><sec:loggedInUserInfo field="username"/></strong>
      					<small class="pull-right"><g:link controller='logout'>Cerrar sesión</g:link></small>
      				</h1>
  				</div>

  				<div class="panel-body">
    				<img src="${resource(dir: 'images', file: 'admin.jpg')}" class="img-responsive img-rounded">
  				</div>
			</div>
		</div>
	</div>
</div>