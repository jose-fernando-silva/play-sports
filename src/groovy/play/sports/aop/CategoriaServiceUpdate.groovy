package play.sports.aop

import play.sports.Categoria

import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

import org.springframework.stereotype.Component

@Component
@Aspect
class CategoriaServiceUpdate {

    @Pointcut(
        value='execution(void play.sports.CategoriaService.update(..)) && bean(categoriaService) && args(categoria)',
        argNames='categoria')
    public void update( Categoria categoria ) {}

    @Before('update(categoria)')
    void before( Categoria categoria ) {
        log.info( "Begins request: ${categoria}" )
    }

    @AfterReturning(
        pointcut='update(play.sports.Categoria)')
    void afterReturning() {
        log.info( "End of request" )
    }

    @AfterThrowing(
        pointcut='update(play.sports.Categoria)',
        throwing='e' )
    void afterThrowing( Exception e ) {

        def message = '' << ''
        message << "Error in request"
        message << ": ${e.class.simpleName} - ${e.message}"
        log.info( message.toString() )

    }

}