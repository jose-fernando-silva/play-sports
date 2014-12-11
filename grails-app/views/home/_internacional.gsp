<section id="internacional">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <h2 class="pull-right"><strong>Fútbol Internacional</strong></h2>
            </div>
            <div class="clearfix"></div>
            <hr>
        </div>
        <div class="row">
            <g:each in="${noticiasInternacionales}" var="noticia">
                <div class="col-xs-12 col-sm-4">
                    <div class="row">
                        <div class="col-xs-5"><br><img class="img-responsive img-thumbnail" src="${noticia.imagen}" width="100%"><br><strong class="pull-right"><g:mostrarFecha fecha="${noticia.fechaPublicacion}"/></strong></div>
                        <div class="col-xs-7">
                            <h3><strong>${noticia.titulo}</strong></h3>
                            <g:link controller="noticia" action="mostrarNoticia" class="btn btn-warning" id="${noticia.id}" params="[categoria: 'FÚTBOL INTERNACIONAL']"><strong>Leer más</strong></g:link>
                        </div>
                    </div>
                </div>
            </g:each>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <br><br><br>
                <g:link controller="noticia" action="mostrarNoticias" params="[categoria: 'FÚTBOL INTERNACIONAL']" class="btn btn-default pull-right"><strong>Más Noticias</strong></g:link>
            </div>
        </div>
        <br>
    </div>
</section>