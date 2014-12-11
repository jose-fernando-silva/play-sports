<style type="text/css">
 .tamanio {
 	min-height: 200px;
 }
</style>
<div class="col-xs-12 col-sm-4">
    <div class="row">
		<div class="panel panel-info tamanio" style="width:98%;">
			<div class="panel-body">
		    	<div class="col-md-5"><br><img class="img-responsive img-thumbnail" src="${noticia.imagen}" width="100%"><br><strong class="pull-right"><g:mostrarFecha fecha="${noticia.fechaPublicacion}"/></strong></div>
		        <div class="col-md-7">
		            <h4><strong>${noticia.titulo}</strong></h4>
		            <g:link controller="noticia" action="mostrarNoticia" class="btn btn-warning" id="${noticia.id}" params="[categoria: categoria.nombre]"><strong>Leer más</strong></g:link>
		        </div>
		  	</div>
		</div>        
    </div>
</div>
