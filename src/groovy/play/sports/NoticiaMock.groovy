package play.sports

class NoticiaMock {

    static Noticia mock( id ) {

        def instance = new Noticia(
            titulo:'A',
            fechaPublicacion:new Date(),
            redactor:'A',
            contenido:'A',
            imagen:'A',
            categoria:new Categoria(),
        )
        instance

    }

}