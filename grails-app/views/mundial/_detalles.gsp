<style type="text/css">
	.linea {
		display: inline-block;
	}
	.grafica {
		width: 100%;
		height: auto;
	}
</style>
<script src="${resource(dir: 'js', file: 'jquery.js')}"></script>
<script src="${resource(dir: 'js/RGraph/libraries', file: 'RGraph.common.core.js')}" ></script>
<script src="${resource(dir: 'js/RGraph/libraries', file: 'RGraph.common.tooltips.js')}" ></script>
<script src="${resource(dir: 'js/RGraph/libraries', file: 'RGraph.common.dynamic.js')}" ></script>
<script src="${resource(dir: 'js/RGraph/libraries', file: 'RGraph.common.effects.js')}"></script>
<script src="${resource(dir: 'js/RGraph/libraries', file: 'RGraph.pie.js')}" ></script>
<script src="${resource(dir: 'js/RGraph/libraries', file: 'RGraph.bar.js')}" ></script>
<script>
    $(document).ready(function (){
		var data = ${[detalles['ganados'] as int, detalles['empatados'] as int, detalles['perdidos'] as int]}
		var totalPartidos = ${detalles['jj'] as int};		
		var tooltips = [];
		$.each(data, function(index, valor) {
			var por = (valor * 100) /totalPartidos;
			por = por.toFixed(2);
			tooltips.push(por + "%");
		});

		var pie = new RGraph.Pie('circular', data)
            .set('labels', ['Ganados','Empatados','Perdidos'])
            .set('tooltips', tooltips)
            .set('tooltips.event', 'onmousemove')
            .set('colors', ['#5cb85c','#eee','#d9534f'])
            .set('strokestyle', 'white')
            .set('linewidth', 1)
            .set('shadow', true)
            .set('shadow.offsetx', 3)
            .set('shadow.offsety', 3)
            .set('shadow.blur', 4)
            .set('exploded', 10)
    
      	pie.draw()
        .roundRobin();

        var data2 = ${[detalles['favor'] as int, detalles['contra'] as int]};
        var favor = ${detalles['favor']} + " goles";
        var contra = ${detalles['contra']} + " goles";
        var tool = [favor, contra];
		var bar = new RGraph.Bar('barras', data2)
                .set('labels', ['Goles Marcados','Goles en Contra'])
                .set('colors', ['#5cb85c'])
                .set('tooltips', tool)
            	.set('tooltips.event', 'onmousemove')
                .grow();
    });
</script>
<div class="panel panel-info">
	<div class="panel-heading">
    	<h2>
    		<img src="${equipo.logo}" class="img-responsive img-rounded linea">
    		<span>${equipo.nombre}</span>
    	</h2>
  	</div>
  	<div class="panel-body">
  		<div class="panel panel-danger">
  			<div class="panel-body">
				<h2>Partidos</h2>
    			<canvas id="circular" class="grafica">[No canvas support]</canvas>		
  			</div>
		</div>
		<br>
		<div class="panel panel-danger">
  			<div class="panel-body">
				<h2>Goles</h2>
    			<canvas id="barras" class="grafica">[No canvas support]</canvas>		
  			</div>
		</div>
	</div>
</div>
