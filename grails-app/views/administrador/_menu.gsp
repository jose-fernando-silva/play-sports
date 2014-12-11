<div class="list-group">

	<!--Principal -->
    <g:remoteLink 
    	  class="list-group-item item-home" 
        controller="administrador" 
        action="admin"
        method="GET" 
        update="contenido" 
        before="\$(this).find('.loading').show()" 
        onComplete="\$('.loading').hide();\$('.list-group-item').removeClass('active');\$('.item-home').addClass('active');">
        Home
        <span class="loading">
            <span class="glyphicon glyphicon-refresh spinner"/>
        </span>
    </g:remoteLink>

	<!-- Categoria de noticias -->
  	<g:remoteLink 
  		class="list-group-item item-categoria" 
  		controller="categoria" 
  		method="GET" update="contenido" 
  		before="\$(this).find('.loading').show()" 
  		onComplete="\$('.loading').hide();\$('.list-group-item').removeClass('active');\$('.item-categoria').addClass('active');">
		Categoría
		<span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span>
  	</g:remoteLink>

  	<!-- Noticias -->
  	<g:remoteLink 
  		class="list-group-item item-noticia" 
  		controller="noticia" 
  		method="GET" update="contenido" 
  		before="\$(this).find('.loading').show()" 
  		onComplete="\$('.loading').hide();\$('.list-group-item').removeClass('active');\$('.item-noticia').addClass('active');">
		Noticias
		<span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span>
  	</g:remoteLink>

  	<!-- Ligas -->
  	<g:remoteLink 
  		class="list-group-item item-liga" 
  		controller="liga" 
  		method="GET" update="contenido" 
  		before="\$(this).find('.loading').show()" 
  		onComplete="\$('.loading').hide();\$('.list-group-item').removeClass('active');\$('.item-liga').addClass('active');">
		Ligas
		<span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span>
  	</g:remoteLink>

  	<!-- Equipos -->
  	<g:remoteLink 
  		class="list-group-item item-equipos" 
  		controller="equipo" 
  		method="GET" update="contenido" 
  		before="\$(this).find('.loading').show()" 
  		onComplete="\$('.loading').hide();\$('.list-group-item').removeClass('active');\$('.item-equipos').addClass('active');">
		Equipos
		<span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span>
  	</g:remoteLink>



	<!-- Carga de equipos -->
  	<g:remoteLink 
  		class="list-group-item item-cargar-equipo" 
  		controller="equipo" 
  		action="formCargarEquipos" 
  		method="GET" update="contenido" 
  		before="\$(this).find('.loading').show()" 
  		onComplete="\$('.loading').hide();\$('.list-group-item').removeClass('active');\$('.item-cargar-equipo').addClass('active');">
		Cargar Equipos
		<span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span>
  	</g:remoteLink>

	<!--<g:each var="c" in="${grailsApplication.controllerClasses.sort {it.fullName} }">
  		<g:if test="${c.logicalPropertyName != 'home'}">
  		<g:remoteLink class="list-group-item item-${c.logicalPropertyName}" controller="${c.logicalPropertyName}" method="GET" update="contenido" before="\$(this).find('.loading').show()" onComplete="\$('.loading').hide();\$('.list-group-item').removeClass('active');\$('.item-${c.logicalPropertyName}').addClass('active');">
		${c.name}
		<span class="loading">
	  		<span class="glyphicon glyphicon-refresh spinner"/>
		</span>
  		</g:remoteLink>
  		</g:if>
  	</g:each>-->
</div>