package play.sports.aop

import play.sports.Liga

import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

import org.springframework.stereotype.Component

@Component
@Aspect
class LigaServiceDelete {

    @Pointcut(
        value='execution(void play.sports.LigaService.delete(..)) && bean(ligaService) && args(liga)',
        argNames='liga')
    public void delete( Liga liga ) {}

    @Before('delete(liga)')
    void before( Liga liga ) {
        log.info( "Begins request:${liga}" )
    }

    @AfterReturning(
        pointcut='delete(play.sports.Liga)')
    void afterReturning() {
        log.info( "End of request" )
    }

    @AfterThrowing(
        pointcut='delete(play.sports.Liga)',
        throwing='e' )
    void afterThrowing( Exception e ) {

        def message = '' << ''
        message << "Error in request"
        message << ": ${e.class.simpleName} - ${e.message}"
        log.info( message.toString() )

    }

}