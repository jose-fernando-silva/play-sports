<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
    
        <!-- Para Movil-->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#colapsable">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/play-sports">Play Sports</a>
        </div>

    
        <div class="collapse navbar-collapse" id="colapsable">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Noticias <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><g:link controller="noticia" action="mostrarNoticias" params="[categoria: 'FÚTBOL NACIONAL']">FÚTBOL NACIONAL</g:link></li>
                            <li><g:link controller="noticia" action="mostrarNoticias" params="[categoria: 'FÚTBOL INTERNACIONAL']">FÚTBOL INTERNACIONAL</g:link></li>
                            <li><g:link controller="noticia" action="mostrarNoticias" params="[categoria: 'MUNDIAL']">MUNDIAL</g:link></li>
                            <li><g:link controller="noticia" action="mostrarNoticias" params="[categoria: 'SELECCIÓN MEXICANA']">SELECCIÓN MEXICANA</g:link></li>
                        </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Estadísticas <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><g:link controller="estadisticas">Posiciones</g:link></li>
                            <li><g:link controller="estadisticas" action="formCalendario">Calendario</g:link></li>
                        </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Liga MX <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><g:link controller="ligaMX" action="posiciones">Posiciones</g:link></li>
                        <li><g:link controller="ligaMX" action="calendario">Calendario</g:link></li>
                        <li><g:link controller="ligaMX" action="liguilla">Liguilla</g:link></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mundial Brasil 2014<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><g:link controller="mundial" action="grupos">Grupos</g:link></li>
                        <li><g:link controller="mundial" action="calendario">Calendario</g:link></li>
                    </ul>
                </li>
          </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>