package play.sports

class EquipoMock {

    static Equipo mock( id ) {

        def instance = new Equipo(
            nombre:'A',
            logo:'A',
            identificador:1,
            liga:new Liga(),
        )
        instance

    }

}