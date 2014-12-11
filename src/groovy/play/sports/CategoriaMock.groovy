package play.sports

class CategoriaMock {

    static Categoria mock( id ) {

        def instance = new Categoria(
            nombre:'A',
            descripcion:'A',
        )
        instance

    }

}