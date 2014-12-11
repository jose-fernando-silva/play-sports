<style type="text/css">
    .letra {
        font-size: 1.3em;
    }
    body {
        margin-top: 70px;
    }
</style>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h2>${noticia.titulo}</h2>
    </div>
    <div class="panel-body">
        <div>
            <span><strong>${noticia.redactor}</strong></span>
            <span class="pull-right"><strong><g:mostrarFecha fecha="${noticia.fechaPublicacion}"/></strong></span>
        </div>
        <div class="clearfix"></div>
        <br>
        <img class="img-responsive img-rounded" width="100%" src="${noticia.imagen}">
        <br>
        <p class="lead letra">${noticia.contenido}</p>
    </div>
</div>