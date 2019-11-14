package eu.mc80.java.librariestests

import spock.lang.Specification


class SpockSpec extends Specification {
    def setupSpec() {}    // runs once -  before the first feature method
    def setup() {
        // explicit conditions
        assert [].isEmpty()
    }        // runs before every feature method
    def cleanup() {}      // runs after every feature method
    def cleanupSpec() {}  // runs once -  after the last feature method

    def "when, then"() {
        when:
        def sum = 1 + 1

        then:
        sum == 2
    }

    def "exception"() {
        when:
        [].get(0)

        then:
        thrown(IndexOutOfBoundsException)
    }
}