<!DOCTYPE html>
<html>
    <head>
        <title><g:message code="app.name" default="Grails App Name"/></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${resource(plugin:'optimus', dir: 'css', file: 'bootstrap.min.css')}" type="text/css" media="screen">
        <link rel="stylesheet" href="${resource(plugin:'optimus', dir: 'css', file: 'main.css')}" type="text/css">
    </head>
    <body>
        <div>
            <g:render template="/header"/>
        </div>
        <div class="col-sm-3 col-lg-2 hidden-xs">
            <g:render template="/menu"/>
        </div>
        <div id="content" class="col-sm-9 col-lg-10">
            <g:render template="/home/index"/>
        </div>
        <script src="${resource(dir: 'js', file: 'jquery.js')}"></script>
        <script src="${resource(dir: 'js', file: 'bootstrap.js')}"></script>
    </body>
</html>
