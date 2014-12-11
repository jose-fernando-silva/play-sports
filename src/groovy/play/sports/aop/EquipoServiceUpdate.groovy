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
class EquipoServiceUpdate {

    @Pointcut(
        value='execution(void play.sports.EquipoService.update(..)) && bean(equipoService) && args(equipo)',
        argNames='equipo')
    public void update( Equipo equipo ) {}

    @Before('update(equipo)')
    void before( Equipo equipo ) {
        log.info( "Begins request: ${equipo}" )
    }

    @AfterReturning(
        pointcut='update(play.sports.Equipo)')
    void afterReturning() {
        log.info( "End of request" )
    }

    @AfterThrowing(
        pointcut='update(play.sports.Equipo)',
        throwing='e' )
    void afterThrowing( Exception e ) {

        def message = '' << ''
        message << "Error in request"
        message << ": ${e.class.simpleName} - ${e.message}"
        log.info( message.toString() )

    }

}