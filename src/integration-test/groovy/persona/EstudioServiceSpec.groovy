package persona

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EstudioServiceSpec extends Specification {

    EstudioService estudioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Estudio(...).save(flush: true, failOnError: true)
        //new Estudio(...).save(flush: true, failOnError: true)
        //Estudio estudio = new Estudio(...).save(flush: true, failOnError: true)
        //new Estudio(...).save(flush: true, failOnError: true)
        //new Estudio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //estudio.id
    }

    void "test get"() {
        setupData()

        expect:
        estudioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Estudio> estudioList = estudioService.list(max: 2, offset: 2)

        then:
        estudioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        estudioService.count() == 5
    }

    void "test delete"() {
        Long estudioId = setupData()

        expect:
        estudioService.count() == 5

        when:
        estudioService.delete(estudioId)
        sessionFactory.currentSession.flush()

        then:
        estudioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Estudio estudio = new Estudio()
        estudioService.save(estudio)

        then:
        estudio.id != null
    }
}
