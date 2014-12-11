<div class="panel panel-info">
	<div class="panel-heading">
		<h2>
			<g:if test="${grupo != null}">
				${grupo}
			</g:if>
		</h2>
	</div>
  	<div class="panel-body" id="tablaEstadisticas">
  		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Equipo</th>
						<th>Puntos</th>
						<th>J.J.</th>
						<th>J.G.</th>
						<th>J.E.</th>
						<th>J.P.</th>
						<th>G.F.</th>
						<th>G.C.</th>
						<th>DIF</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${tabla}" var="registro" status="pos">
						<tr>
							<td><g:remoteLink 
								update="detalles" 
								action="detalles" 
								before="\$(document).find('#l').show()" 
        						onComplete="\$(document).find('#l').hide()"
								params="${[equipo: registro.team, posicion: pos + 1, puntos: registro.points, puntos: registro.points, jj: registro.round, ganados: registro.wins, empatados: registro.draws, perdidos: registro.losses, favor: registro.gf, contra: registro.ga, dif: registro.avg]}">
									${registro.team}
								</g:remoteLink></td>
							<td>${registro.points}</td>
							<td><g:juegosJugados wins="${registro.wins}" draws="${registro.draws}" losses="${registro.losses}"/></td>
							<td>${registro.wins}</td>
							<td>${registro.draws}</td>
							<td>${registro.losses}</td>
							<td>${registro.gf}</td>
							<td>${registro.ga}</td>
							<td>${registro.avg}</td>
						</tr>
					</g:each>
				</tbody>
			</table>	
		</div>
  	</div>
</div>
