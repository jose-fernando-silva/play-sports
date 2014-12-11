package play.sports.aop

import play.sports.Equipo

import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

import org.springframework.stereotype.Component

@Component
@Aspect
class EquipoServiceDelete {

    @Pointcut(
        value='execution(void play.sports.EquipoService.delete(..)) && bean(equipoService) && args(equipo)',
        argNames='equipo')
    public void delete( Equipo equipo ) {}

    @Before('delete(equipo)')
    void before( Equipo equipo ) {
        log.info( "Begins request:${equipo}" )
    }

    @AfterReturning(
        pointcut='delete(play.sports.Equipo)')
    void afterReturning() {
        log.info( "End of request" )
    }

    @AfterThrowing(
        pointcut='delete(play.sports.Equipo)',
        throwing='e' )
    void afterThrowing( Exception e ) {

        def message = '' << ''
        message << "Error in request"
        message << ": ${e.class.simpleName} - ${e.message}"
        log.info( message.toString() )

    }

}