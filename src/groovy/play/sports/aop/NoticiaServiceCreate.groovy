package play.sports.aop

import play.sports.Noticia

import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

import org.springframework.stereotype.Component

@Component
@Aspect
class NoticiaServiceCreate {

    @Pointcut(
        value='execution(void play.sports.NoticiaService.create(..)) && bean(noticiaService) && args(noticia)',
        argNames='noticia')
    public void create( Noticia noticia ) {}

    @Before('create(noticia)')
    void before( Noticia noticia ) {
        log.info( "Begins request: ${noticia}" )
    }

    @AfterReturning(
        pointcut='create(play.sports.Noticia)')
    void afterReturning() {
        log.info( "End of request" )
    }

    @AfterThrowing(
        pointcut='create(play.sports.Noticia)',
        throwing='e' )
    void afterThrowing( Exception e ) {

        def message = '' << ''
        message << "Error in request"
        message << ": ${e.class.simpleName} - ${e.message}"
        log.info( message.toString() )

    }

}