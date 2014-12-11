package play.sports

class LigaMock {

    static Liga mock( id ) {

        def instance = new Liga(
            year:1,
            group_code:1,
            playoff:1,
            name:'A',
            country:'A',
            current_round:1,
            total_group:1,
            total_rounds:1,
            flag:null,
            phase:null,
            identificador:1,
        )
        instance

    }

}