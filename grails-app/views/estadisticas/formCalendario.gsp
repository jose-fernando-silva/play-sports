<!DOCTYPE html>
<html>
    <head>
        <title>Calendario de Partidos</title>
        <meta name="layout" content="main" />
        <script src="${resource(dir: 'js', file: 'jquery.js')}"></script>
    </head>
    <body>
        <div class="container" style="margin-top: 70px;">
            <div class="row">
                <div class="col-xs-12 col-md-2">
                    <g:render template="formCalendario" />
                </div>
                <div id="partidos" class="col-md-10">
                </div>
            </div>
        </div>
    </body>
</html>