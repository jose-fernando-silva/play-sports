<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/play-sports">Play Sports</a>
        </div>

        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <!--<ul class="nav navbar-nav">
                <li class="item-home active">
                    <g:remoteLink 
                        controller="home" 
                        method="GET" 
                        update="content" 
                        before="\$(this).find('.loading').show()" 
                        onComplete="\$('.loading').hide();
                                    \$('.navbar-nav li').removeClass('active');
                                    \$('.item-home').addClass('active');">
                        Home
                        <span class="loading">
                            <span class="glyphicon glyphicon-refresh spinner"/>
                        </span>
                    </g:remoteLink>
                </li>
                <li class="item-categoria" >
                    <!-- Categoria de noticias -->
                    <g:remoteLink 
                        controller="categoria" 
                        method="GET" update="contenido" 
                        before="\$(this).find('.loading').show()" 
                        onComplete="\$('.loading').hide();\$('.navbar-nav li').removeClass('active');\$('.item-categoria').addClass('active');">
                        Categoría
                        <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span>
                    </g:remoteLink>
                </li>
                <li class="item-noticia" >
                    <!-- Noticias -->
                    <g:remoteLink 
                        controller="noticia" 
                        method="GET" update="contenido" 
                        before="\$(this).find('.loading').show()" 
                        onComplete="\$('.loading').hide();\$('.navbar-nav li').removeClass('active');\$('.item-noticia').addClass('active');">
                        Noticias
                        <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span>
                    </g:remoteLink>
                </li>
                <li class="item-liga" >
                    <!-- Ligas -->
                    <g:remoteLink 
                        controller="liga" 
                        method="GET" update="contenido" 
                        before="\$(this).find('.loading').show()" 
                        onComplete="\$('.loading').hide();\$('.navbar-nav li').removeClass('active');\$('.item-liga').addClass('active');">
                        Ligas
                        <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span>
                    </g:remoteLink>
                </li>
                <li class="item-equipos" >
                    <!-- Equipos -->
                    <g:remoteLink 
                        controller="equipo" 
                        method="GET" update="contenido" 
                        before="\$(this).find('.loading').show()" 
                        onComplete="\$('.loading').hide();\$('.navbar-nav li').removeClass('active');\$('.item-equipos').addClass('active');">
                        Equipos
                        <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span>
                    </g:remoteLink>
                </li>
                <li class="item-cargar-equipo" >
                    <!-- Carga de equipos -->
                    <g:remoteLink 
                        controller="equipo" 
                        action="formCargarEquipos" 
                        method="GET" update="contenido" 
                        before="\$(this).find('.loading').show()" 
                        onComplete="\$('.loading').hide();\$('.navbar-nav li').removeClass('active');\$('.item-cargar-equipo').addClass('active');">
                        Cargar Equipos
                        <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span>
                    </g:remoteLink>
                </li>
            </ul>-->
        </div>
    </div><!-- fin caontainer -->
</nav>
